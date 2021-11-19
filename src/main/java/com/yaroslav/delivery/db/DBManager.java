package com.yaroslav.delivery.db;

import com.yaroslav.delivery.db.entity.*;
import com.yaroslav.delivery.model.UserModel;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class DBManager {


    private static final Lock CONNECTION_LOCK = new ReentrantLock();
    private static final String DELETE_ORDER_SQL = "delete from orderuser where id = ?;";
    public static Connection connection;
    private static DBManager dbManager;
    private static final String FIND_ALL_USERS = "SELECT * FROM user";
    private static final String FIND_ALL_ORDERS = "SELECT * FROM orderuser";
    private static final String FIND_ALL_ROUTES = "SELECT * FROM route";
    private static final String FIND_ALL_LUGGAGE = "SELECT * FROM luggage";
    private static final String FIND_PRICE = "SELECT * FROM price";
    private static final Logger LOG = Logger.getLogger(DBManager.class.getName());
    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (name, password , number , email) VALUES " + " (?,?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,password,number from user where id =?";
    private static final String SELECT_ORDER_BY_ID = "select id,user,route,volume,weight from orderuser where id =?";
    private static final String FIND_ALL_ORDERS_BY_USER = "select id,route,volume,weight,price,payment,date,type from orderuser where user =?";
    private static final String SELECT_ROUTE_BY_ID = "select way from route where kilometers =?";
    private static final String SELECT_USER_BY_EMAIL = "select id,name,email,password,number from user where email =?";
    private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
    private static final String UPDATE_USERS_SQL = "update user set name = ?, password =? , number= ? ,email= ? where id = ?;";
    private static final String UPDATE_ORDER_SQL = "update orderuser set user = ? , route = ?, volume =? , weight= ? ,price= ? ,date=? , type = ? where id = ?;";
    private static final String UPDATE_ORDERPAYMENT_SQL = "update orderuser set payment= ? where id = ?;";
    private static final String AUTHENTICATE = "select * from user where email=? and password = ?";
    private static final String INSERT_ORDER_SQL = "INSERT INTO orderuser (user, route , volume , weight , price , payment ,date ,type) VALUES  (?,?,?,?,?,?,?,?);";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        } catch (SQLException e) {
            LOG.info(e.getMessage());
        }
        return null;
    }

    public DBManager() {
        connection = getConnection();
    }

    private DBManager(String host, String user, String password) throws IOException {
        connection = getConnection();
    }

    public static DBManager getInstance(String host, String user, String password) {
        if (dbManager == null) {
            try {
                dbManager = new DBManager(host, user, password);
            } catch (IOException e) {
                LOG.info(e.getMessage());
            }
        }
        return dbManager;
    }


    public static void insertUser(User user) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNumber());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.info("insertUser error " + e.getMessage());
        }
    }

    public static User selectUser(int id) {
        User user = new User();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String login = rs.getString("name");
                String password = rs.getString("password");
                String number = rs.getString("number");
                String email = rs.getString("email");

                user = new User(id, login, password, number, email);
            }
        } catch (SQLException e) {
            LOG.info("error in selectUser!");
        }
        return user;
    }

    public User selectUserByEmail(String email) {
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String login = rs.getString("name");
                String password = rs.getString("password");
                String number = rs.getString("number");
                int id = rs.getInt("id");

                user = new User(id, login, password, number, email);
            }
        } catch (SQLException e) {
            LOG.info("error in selectUser!");
        }
        return user;
    }

    public static Order selectOrder(int id) {
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer idUser = rs.getInt("user");
                String way = rs.getString("route");
                Integer volume = rs.getInt("volume");
                Integer weight = rs.getInt("weight");
                order = new Order(id, idUser, way, volume, weight);
            }
        } catch (SQLException e) {
            LOG.info("error in selectOrder!" + e.getMessage());
        }
        return order;
    }

    public String selectWay(int id) {
        String idUser = " " ;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROUTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                idUser = rs.getString("way");
            }
        } catch (SQLException e) {
            LOG.info("error in selectWay!" + e.getMessage());
        }
        return idUser;
    }

    public List<UserModel> findAllUsers() {
        List<UserModel> users = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            CONNECTION_LOCK.lock();
            try (ResultSet rs = ps.executeQuery(FIND_ALL_USERS)) {
                while (rs.next()) {
                    UserModel user = new UserModel();
                    users.add(user);
                    user.setId(rs.getInt(1));
                    user.setLogin(rs.getString(2));
                    user.setNumber(rs.getString(3));
                    user.setMail(rs.getString(4));
                    user.setPassword(rs.getString(5));
                }
            }
        } catch (Exception e) {
            LOG.info(e.getMessage());
            return Collections.emptyList();

        }
        CONNECTION_LOCK.unlock();
        return users;
    }

    public List<Order> findAllOrderByUsers(int idUser) {
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_ORDERS_BY_USER)) {
            preparedStatement.setInt(1, idUser);
            ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Order order = new Order();
                    orders.add(order);
                    order.setIdUser(idUser);
                    order.setId( rs.getInt("id"));
                    order.setWay(rs.getString("route"));
                    order.setVolume(rs.getInt("volume"));
                    order.setWeight(rs.getInt("weight"));
                    order.setPrice(rs.getInt("price"));
                    order.setPayment(rs.getString("payment"));
                    order.setDate(rs.getString("date"));
                    order.setType(rs.getString("type"));
                }

        } catch (Exception e) {
            LOG.info(" Error in method findAllOrder = " + e.getMessage());
            return Collections.emptyList();

        }
        return orders;
    }


    public List<Order> findAllOrder() {
        List<Order> orders = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {

            try (ResultSet rs = ps.executeQuery(FIND_ALL_ORDERS)) {
                while (rs.next()) {
                    Order order = new Order();
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
            LOG.info(" Error in method findAllOrder = " + e.getMessage());
            return Collections.emptyList();

        }
        return orders;
    }

    public static List<Route> findAllRoute() {
        List<Route> routes = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            CONNECTION_LOCK.lock();
            try (ResultSet rs = ps.executeQuery(FIND_ALL_ROUTES)) {
                while (rs.next()) {
                    Route route = new Route();
                    routes.add(route);
                    route.setId(rs.getInt(1));
                    route.setKilometers(rs.getInt(2));
                    route.setWay(rs.getString(3));
                }
            }
        } catch (Exception e) {
            LOG.info(e.getMessage());
            return Collections.emptyList();

        }
        CONNECTION_LOCK.unlock();
        return routes;
    }

    public static List<Luggage> findAllLuggage() {
        List<Luggage> luggages = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            CONNECTION_LOCK.lock();
            try (ResultSet rs = ps.executeQuery(FIND_ALL_LUGGAGE)) {
                while (rs.next()) {
                    Luggage luggage = new Luggage();
                    luggages.add(luggage);
                    luggage.setId(rs.getInt(1));
                    luggage.setType(rs.getString(2));
                }
            }
        } catch (Exception e) {
            LOG.info(e.getMessage());
            return Collections.emptyList();

        }
        CONNECTION_LOCK.unlock();
        return luggages;
    }

    public List<Price> findPrice() {
        List<Price> prices = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            CONNECTION_LOCK.lock();
            try (ResultSet rs = ps.executeQuery(FIND_PRICE)) {
                while (rs.next()) {
                    Price price = new Price();
                    prices.add(price);
                    price.setId(rs.getInt(1));
                    price.setKilometer(rs.getInt(2));
                    price.setVolume(rs.getInt(3));
                    price.setWeight(rs.getInt(4));
                }
            }
        } catch (Exception e) {
            LOG.info(e.getMessage());
            return Collections.emptyList();

        }
        CONNECTION_LOCK.unlock();
        return prices;
    }

    public static void deleteUser(int id) throws SQLException {

        try (PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public static void  updateUser(User user) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getNumber());
            statement.setString(4, user.getMail());
            statement.setInt(5, user.getId());

            statement.executeUpdate();
        }
    }
    public static void  updateOrder(Order order) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL)) {
            statement.setInt(1, order.getIdUser());
            statement.setString(2, order.getWay());
            statement.setInt(3, order.getVolume());
            statement.setInt(4, order.getWeight());

            int route = order.getIdRoute();
            int volume = order.getVolume();
            int weight = order.getWeight();
            int i = (volume + weight) * 2 + route * 4;
            order.setPrice(i);
            statement.setInt(5, i);
            statement.setString(6, order.getDate());
            statement.setString(7, order.getType());
            statement.setInt(8  , order.getId());

            statement.executeUpdate();
        }
    }

    public static void  updateOrderPayment(Order order) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ORDERPAYMENT_SQL)) {
            statement.setString(1 ,order.getPayment());
            statement.setInt(2, order.getId());
            statement.executeUpdate();
        }
    }

    public static String authenticate(String name, String password) throws SQLException {
        try (PreparedStatement st = connection.prepareStatement(AUTHENTICATE)) {
            st.setString(1, name);
            st.setString(2, password);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                do {
                    return result.getString("name");

                } while (result.next());
            }
        } catch (SQLException e) {
            System.out.println("Error :" + e.getMessage());
        }
        return null;
    }

    public static void insertOrder(Order order) throws SQLException {
        int i;

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {

            String way = dbManager.selectWay(order.getIdRoute());
            preparedStatement.setInt(1, order.getIdUser());
            preparedStatement.setString(2, way);
            preparedStatement.setInt(3, order.getVolume());
            preparedStatement.setInt(4, order.getWeight());
            int route = order.getIdRoute();
            int volume = order.getVolume();
            int weight = order.getWeight();
            i = (volume + weight) * 2 + route * 4;
            order.setPrice(i);
            preparedStatement.setInt(5, i);
            preparedStatement.setString(6 , order.getPayment());
            preparedStatement.setString(7 , order.getDate());
            preparedStatement.setString(8 , order.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.info("insertOrder error = " + e.getMessage());
        }
    }

    public static void deleteOrder(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

}
