package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.Luggage;
import com.yaroslav.delivery.db.entity.Route;
import com.yaroslav.delivery.model.LuggageModel;
import com.yaroslav.delivery.model.OrderModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuggageDAO {
    private static final String FIND_ALL_LUGGAGE = "SELECT * FROM luggage";

    public  List<LuggageModel> findAllLuggage() {
        List<LuggageModel> luggageList = new ArrayList<>();
        try (Connection connection = DBManager.getConnection(); Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(FIND_ALL_LUGGAGE)) {
                while (rs.next()) {
                    LuggageModel luggage = new LuggageModel();
                    luggageList.add(luggage);
                    luggage.setId(rs.getInt(1));
                    luggage.setType(rs.getString(2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return luggageList;
    }
}
