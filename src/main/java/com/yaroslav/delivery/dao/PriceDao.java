package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.model.PriceModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceDao {

    private static final String SELECT_PRICES_SQL = "SELECT * FROM price";
    private static final DBManager dbManager = new DBManager();


    public List<PriceModel> selectPrices() {
        List<PriceModel> prices = new ArrayList<>();
        try (Connection connection = dbManager.getConnection();
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
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return prices;
    }
}
