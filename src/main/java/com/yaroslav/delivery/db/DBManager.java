package com.yaroslav.delivery.db;

import com.yaroslav.delivery.db.entity.*;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Logger;

public class DBManager {

    public static Connection connection;
    private static DBManager dbManager;
    private static final Logger LOG = Logger.getLogger(DBManager.class.getName());
    private static final String SELECT_USER_BY_EMAIL = "select id,name,email,password,number from user where email =?";
     private static final String AUTHENTICATE = "select * from user where email=? and password = ?";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        } catch (SQLException e) {
            LOG.info(e.getMessage());
            throw new RuntimeException(e);
        }
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
}
