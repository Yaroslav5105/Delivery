package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.model.OrderModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDAO {

    private static final String FIND_ALL_ORDERS_BY_USER = "select id,route,volume,weight,price,payment,date,type from orderuser where user =?";
    private static final String UPDATE_ORDER_SQL = "update orderuser set user = ? , route = ?, volume =? , weight= ? ,price= ? ,date=? , type = ? where id = ?;";
    private static final String INSERT_ORDER_SQL = "INSERT INTO orderuser (user, route , volume , weight , price , payment ,date ,type) VALUES  (?,?,?,?,?,?,?,?);";
    private static final String SELECT_ROUTE_BY_ID = "select way from route where kilometers =?";
    private static final String FIND_ALL_ORDERS = "SELECT * FROM orderuser";
    private static final String DELETE_ORDER_SQL = "delete from orderuser where id = ?;";
    private static final String SELECT_ORDER_BY_ID = "select id,user,route,volume,weight , date ,type from orderuser where id =?";
    private static final String UPDATE_ORDERPAYMENT_SQL = "update orderuser set payment= ? where id = ?;";
    private static final Connection connection;

    static {
        new DBManager();
        connection = DBManager.connection;
    }

    public void insertOrder(OrderModel orderModel) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
            int price;
            String way = selectWay(orderModel.getIdRoute());
            preparedStatement.setInt(1, orderModel.getIdUser());
            preparedStatement.setString(2, way);
            preparedStatement.setInt(3, orderModel.getVolume());
            preparedStatement.setInt(4, orderModel.getWeight());
            price = (orderModel.getVolume() + orderModel.getWeight()) * 2 + orderModel.getIdRoute() * 4;
            orderModel.setPrice(price);
            preparedStatement.setInt(5, price);
            preparedStatement.setString(6, orderModel.getPayment());
            preparedStatement.setString(7, orderModel.getDate());
            preparedStatement.setString(8, orderModel.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String selectWay(int id) {
        String idUser = "";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROUTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                idUser = rs.getString("way");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUser;
    }

    public List<OrderModel> findAllOrder() {
        List<OrderModel> orders = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {

            try (ResultSet rs = ps.executeQuery(FIND_ALL_ORDERS)) {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return orders;
    }

    public void delete(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public OrderModel selectOrder(int id) {
        OrderModel orderModel = new OrderModel();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID)) {
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
            e.printStackTrace();
        }
        return orderModel;
    }

    public void updateOrder(OrderModel orderModel) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL)) {
            statement.setInt(1, orderModel.getIdUser());
            statement.setString(2, orderModel.getWay());
            statement.setInt(3, orderModel.getVolume());
            statement.setInt(4, orderModel.getWeight());

            int route = orderModel.getIdRoute();
            int volume = orderModel.getVolume();
            int weight = orderModel.getWeight();
            int i = (volume + weight) * 2 + route * 4;
            orderModel.setPrice(i);
            statement.setInt(5, i);
            statement.setString(6, orderModel.getDate());
            statement.setString(7, orderModel.getType());
            statement.setInt(8, orderModel.getId());

            statement.executeUpdate();
        }
    }

    public void payment(OrderModel order) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ORDERPAYMENT_SQL)) {
            statement.setString(1, order.getPayment());
            statement.setInt(2, order.getId());
            statement.executeUpdate();
        }
    }

    public List<OrderModel> findAllOrderByUsers(int idUser) {
        List<OrderModel> orderModels = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_ORDERS_BY_USER)) {
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

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return orderModels;
    }

}
