package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.converter.InterfacePrice;
import com.yaroslav.delivery.db.ConnectionPool;
import com.yaroslav.delivery.model.OrderModel;
import com.yaroslav.delivery.model.PriceModel;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    private static final Logger LOG = Logger.getLogger(OrderDao.class);

    private static final String SELECT_ORDERS_BY_USER_SQL = "select id,route,volume,weight,price,payment,date,type from orderuser where user =?";
    private static final String SELECT_USER_BY_ID_ORDER_SQL = "select user,route,volume,weight,price,payment,date,type from orderuser where id =?";
    private static final String UPDATE_ORDER_SQL = "update orderuser set user = ? , route = ?, volume =? , weight= ? ,price= ? ,date=? , type = ? where id = ?;";
    private static final String INSERT_ORDER_SQL = "INSERT INTO orderuser (user, route , volume , weight , price , payment ,date ,type) VALUES  (?,?,?,?,?,?,?,?);";
    private static final String SELECT_ORDERS_SQL = "SELECT * FROM orderuser limit ";
    private static final String DELETE_ORDER_SQL = "delete from orderuser where id = ?;";
    private static final String SELECT_ORDER_BY_ID = "select id,user,route,volume,weight , date ,type from orderuser where id =?";
    private static final String UPDATE_ORDER_PAYMENT_SQL = "update orderuser set payment= ? where id = ?;";
    private static final String SELECT_SORT_ORDER_BY_FROM_SMALLER = "SELECT * FROM orderuser ORDER BY date limit ";
    private static final String SELECT_SORT_ORDER_BY_FROM_LARGER = "SELECT * FROM orderuser ORDER BY date DESC limit ";


    public boolean insertOrder(OrderModel orderModel) throws SQLException {
        RouteDao routeDao = new RouteDao();
        PriceDao priceDao = new PriceDao();
        InterfacePrice interfaces;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
            int price;
            String way = routeDao.selectWayById(orderModel.getIdRoute());
            preparedStatement.setInt(1, orderModel.getIdUser());
            preparedStatement.setString(2, way);
            preparedStatement.setInt(3, orderModel.getVolume());
            preparedStatement.setInt(4, orderModel.getWeight());
            PriceModel priceModel = priceDao.selectPrice();
            interfaces = (volume, weight, kilometer) -> (volume * priceModel.getVolume()) + (weight * priceModel.getWeight()) + (kilometer * priceModel.getKilometer());
            price = interfaces.price(orderModel.getVolume(), orderModel.getWeight(), orderModel.getIdRoute());
            orderModel.setPrice(price);
            preparedStatement.setInt(5, price);
            preparedStatement.setString(6, orderModel.getPayment());
            preparedStatement.setString(7, orderModel.getDate());
            preparedStatement.setString(8, orderModel.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can not insert order", e);
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean deleteOrder(int id) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can not delete order", e);
            throw new RuntimeException(e);
        }
        return true;
    }

    public OrderModel selectOrder(int id) {
        OrderModel orderModel = new OrderModel();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer idUser = rs.getInt("user");
                String way = rs.getString("route");
                Integer volume = rs.getInt("volume");
                Integer weight = rs.getInt("weight");
                String date = rs.getString("date");
                String type = rs.getString("type");
                orderModel = new OrderModel(id, idUser, way, volume, weight, date, type);
            }
        } catch (SQLException e) {
            LOG.error("Can not find a order by id", e);
            throw new RuntimeException(e);
        }
        return orderModel;
    }

    public boolean updateOrder(OrderModel orderModel) throws SQLException {
        InterfacePrice interfaces;
        PriceDao priceDao = new PriceDao();

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL)) {
            statement.setInt(1, orderModel.getIdUser());
            statement.setString(2, orderModel.getWay());
            statement.setInt(3, orderModel.getVolume());
            statement.setInt(4, orderModel.getWeight());
            PriceModel priceModel = priceDao.selectPrice();
            interfaces = (volume, weight, kilometer) -> (volume * priceModel.getVolume()) + (weight * priceModel.getWeight()) + (kilometer * priceModel.getKilometer());
            int price = interfaces.price(orderModel.getVolume(), orderModel.getWeight(), orderModel.getIdRoute());
            orderModel.setPrice(price);
            statement.setInt(5, price);
            statement.setString(6, orderModel.getDate());
            statement.setString(7, orderModel.getType());
            statement.setInt(8, orderModel.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can not update order", e);
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean updatePayment(OrderModel order) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_PAYMENT_SQL)) {
            statement.setString(1, order.getPayment());
            statement.setInt(2, order.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can not pay order", e);
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<OrderModel> selectOrdersByUser(int idUser) {
        List<OrderModel> orderModels = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_USER_SQL)) {
            preparedStatement.setInt(1, idUser);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                OrderModel orderModel = new OrderModel();
                orderModels.add(orderModel);
                orderModel.setIdUser(idUser);
                orderModel.setId(rs.getInt("id"));
                orderModel.setWay(rs.getString("route"));
                orderModel.setVolume(rs.getInt("volume"));
                orderModel.setWeight(rs.getInt("weight"));
                orderModel.setPrice(rs.getInt("price"));
                orderModel.setPayment(rs.getString("payment"));
                orderModel.setDate(rs.getString("date"));
                orderModel.setType(rs.getString("type"));
            }

        } catch (SQLException e) {
            LOG.error("Can not select order by id", e);

            throw new RuntimeException(e);
        }
        return orderModels;
    }

    public List<OrderModel> selectOrders(int start, int total) {
        List<OrderModel> orders = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement ps = connection.createStatement();
             ResultSet rs = ps.executeQuery(SELECT_ORDERS_SQL + (start - 1) + "," + total)) {
            while (rs.next()) {
                OrderModel order = new OrderModel();
                orders.add(order);
                order.setId(rs.getInt(1));
                order.setIdUser(rs.getInt(2));
                order.setWay(rs.getString(3));
                order.setVolume(rs.getInt(4));
                order.setWeight(rs.getInt(5));
                order.setPrice(rs.getInt(6));
                order.setPayment(rs.getString(7));
                order.setDate(rs.getString(8));
                order.setType(rs.getString(9));
            }
        } catch (SQLException e) {
            LOG.error("Can not find all orders ", e);
            throw new RuntimeException(e);
        }
        return orders;
    }

    public OrderModel selectUserByIdOrder(int idOrder) {
        OrderModel orderModel = new OrderModel();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_ORDER_SQL)) {
            preparedStatement.setInt(1, idOrder);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                orderModel.setId(idOrder);
                orderModel.setIdUser(rs.getInt("user"));
                orderModel.setWay(rs.getString("route"));
                orderModel.setVolume(rs.getInt("volume"));
                orderModel.setWeight(rs.getInt("weight"));
                orderModel.setPrice(rs.getInt("price"));
                orderModel.setPayment(rs.getString("payment"));
                orderModel.setDate(rs.getString("date"));
                orderModel.setType(rs.getString("type"));

            }

        } catch (SQLException e) {
            LOG.error("Can not select order by id", e);

            throw new RuntimeException(e);
        }
        return orderModel;
    }

    public List<OrderModel> selectOrderSortFromSmaller(int start, int total) {
        List<OrderModel> orders = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement ps = connection.createStatement();
             ResultSet rs = ps.executeQuery(SELECT_SORT_ORDER_BY_FROM_SMALLER + (start - 1) + "," + total)) {
            while (rs.next()) {
                OrderModel order = new OrderModel();
                orders.add(order);
                order.setId(rs.getInt(1));
                order.setIdUser(rs.getInt(2));
                order.setWay(rs.getString(3));
                order.setVolume(rs.getInt(4));
                order.setWeight(rs.getInt(5));
                order.setPrice(rs.getInt(6));
                order.setPayment(rs.getString(7));
                order.setDate(rs.getString(8));
                order.setType(rs.getString(9));
            }
        } catch (SQLException e) {
            LOG.error("Can not find all orders ", e);
            throw new RuntimeException(e);
        }
        return orders;
    }
    public List<OrderModel> selectOrderSortFromLarger(int start, int total) {
        List<OrderModel> orders = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement ps = connection.createStatement();
             ResultSet rs = ps.executeQuery(SELECT_SORT_ORDER_BY_FROM_LARGER + (start - 1) + "," + total)) {
            while (rs.next()) {
                OrderModel order = new OrderModel();
                orders.add(order);
                order.setId(rs.getInt(1));
                order.setIdUser(rs.getInt(2));
                order.setWay(rs.getString(3));
                order.setVolume(rs.getInt(4));
                order.setWeight(rs.getInt(5));
                order.setPrice(rs.getInt(6));
                order.setPayment(rs.getString(7));
                order.setDate(rs.getString(8));
                order.setType(rs.getString(9));
            }
        } catch (SQLException e) {
            LOG.error("Can not find all orders ", e);
            throw new RuntimeException(e);
        }
        return orders;
    }
}
