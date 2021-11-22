package com.yaroslav.delivery.db;

import java.sql.*;
import java.util.logging.Logger;

public class DBManager {

    private static final Logger LOG = Logger.getLogger(DBManager.class.getName());

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        } catch (SQLException e) {
            LOG.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
