package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.Price;
import com.yaroslav.delivery.model.PriceModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceDAO {

    private static final String FIND_PRICE = "SELECT * FROM price";
    private static final Connection connection;

    static {
        new DBManager();
        connection = DBManager.connection;
    }

    public List<PriceModel> findPrice() {
        List<PriceModel> prices = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(FIND_PRICE)) {
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
