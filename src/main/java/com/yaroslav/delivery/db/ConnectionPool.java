package com.yaroslav.delivery.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionPool {
    private static DataSource dataSource;

    public ConnectionPool(DataSource dataSource) {
        ConnectionPool.dataSource = dataSource;
    }

    private final static Logger LOG = Logger.getLogger(ConnectionPool.class.getName());


    public static synchronized Connection getConnection() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/dbdelivery");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            return null;
        }
    }

}
