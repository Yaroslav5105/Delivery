package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.model.LuggageModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LuggageDao {

    private static final Logger LOG = Logger.getLogger(LuggageDao.class.getName());
    private static final String SELECT_LUGGAGES_SQL = "SELECT * FROM luggage";
    private static final DBManager dbManager = new DBManager();

    public List<LuggageModel> selectLuggages() {
        List<LuggageModel> luggageList = new ArrayList<>();
        try (Connection connection = dbManager.getConnection();
             Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(SELECT_LUGGAGES_SQL)) {
                while (rs.next()) {
                    LuggageModel luggage = new LuggageModel();
                    luggageList.add(luggage);
                    luggage.setId(rs.getInt(1));
                    luggage.setType(rs.getString(2));
                }
            }
        } catch (Exception e) {
            LOG.info(e.getMessage());
            throw new RuntimeException(e);
        }
        return luggageList;
    }
}
