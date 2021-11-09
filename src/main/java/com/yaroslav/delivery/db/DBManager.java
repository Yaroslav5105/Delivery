package com.yaroslav.delivery.db;

import com.yaroslav.delivery.db.entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class DBManager {

    private static Connection connection;
    private static final Lock CONNECTION_LOCK = new ReentrantLock();
    private static DBManager dbManager;
    private static final String FIND_ALL_USERS = "SELECT * FROM login";
    private static final Logger LOG = Logger.getLogger(DBManager.class.getName());
    private static final String INSERT_USERS_SQL = "INSERT INTO login" + "  (name, password , number , email) VALUES " + " (?,?,?,?);";

    public Connection getConnection(String host, String user, String password) {
        try {
            return DriverManager.getConnection(host, user, password);
        } catch (SQLException e) {
            LOG.info(e.getMessage());
        }
        return null;
    }

    private DBManager(String host, String user, String password) throws IOException {
        connection = getConnection(host, user, password);
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

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            CONNECTION_LOCK.lock();
            try (ResultSet rs = ps.executeQuery(FIND_ALL_USERS)) {
                while (rs.next()) {
                    User user = new User();
                    users.add(user);
                    user.setId(rs.getInt(1));
                    user.setLogin(rs.getString(2));
                }
            }
        } catch (Exception e) {
            LOG.info(e.getMessage());
            return Collections.emptyList();

        }
        CONNECTION_LOCK.unlock();
        return users;
    }

    public void insertUser(User user) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNumber());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.info("insertUserup error ");
        }
    }
}
