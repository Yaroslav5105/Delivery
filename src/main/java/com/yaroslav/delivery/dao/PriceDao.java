package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.ConnectionPool;
import com.yaroslav.delivery.model.PriceModel;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PriceDao {
    private static final Logger LOG = Logger.getLogger(PriceDao.class.getName());
    private static final String SELECT_PRICES_SQL = "SELECT * FROM price";
    private static final String UPDATE_PRICE_SQL = "update price set kilometer = ? ,  volume =? , weight= ? where id = ?;";


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

    public boolean update(PriceModel priceModel) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRICE_SQL);
            statement.setInt(1, priceModel.getKilometer());
            statement.setInt(2, priceModel.getVolume());
            statement.setInt(3, priceModel.getWeight());
            statement.setInt(4, priceModel.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            LOG.error("Can not select price", e);
            throw new RuntimeException(e);
        }
        return true;
    }
    public PriceModel selectPrice() {
        PriceModel priceModel = new PriceModel();
        try (Connection connection = ConnectionPool.getConnection();
             Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(SELECT_PRICES_SQL)) {
                while (rs.next()) {
                    priceModel.setId(rs.getInt(1));
                    priceModel.setKilometer(rs.getInt(2));
                    priceModel.setVolume(rs.getInt(3));
                    priceModel.setWeight(rs.getInt(4));
                }
            }
        } catch (SQLException e) {
            LOG.error("Can not select price", e);
            throw new RuntimeException(e);
        }
        return priceModel;
    }
}
