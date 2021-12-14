package com.yaroslav.delivery.db;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static DataSource dataSource;
    private final static Logger LOG = Logger.getLogger(ConnectionPool.class);

    public static synchronized Connection getConnection() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/dbdelivery");
            } catch (NamingException e) {
                LOG.error("Cannot find the data source");
            }
        }

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error("Cannot establish connection");
            throw new RuntimeException(e);
        }
    }
}