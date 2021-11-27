package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.ConnectionPool;
import com.yaroslav.delivery.model.PriceModel;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PriceDao {
    private static final Logger LOG = Logger.getLogger(PriceDao.class.getName());
    private static final String SELECT_PRICES_SQL = "SELECT * FROM price";



    public List<PriceModel> selectPrices() {
        List<PriceModel> prices = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(SELECT_PRICES_SQL)) {
                while (rs.next()) {
                    PriceModel price = new PriceModel();
                    prices.add(price);
                    price.setId(rs.getInt(1));
                    price.setKilometer(rs.getInt(2));
                    price.setVolume(rs.getInt(3));
                    price.setWeight(rs.getInt(4));
                }
            }
        } catch (SQLException e) {
            LOG.error("Can not select price", e);
            throw new RuntimeException(e);
        }
        return prices;
    }
}
