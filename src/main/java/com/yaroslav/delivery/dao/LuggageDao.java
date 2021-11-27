package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.ConnectionPool;
import com.yaroslav.delivery.model.LuggageModel;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class LuggageDao {

    private static final Logger LOG = Logger.getLogger(LuggageDao.class.getName());
    private static final String SELECT_LUGGAGES_SQL = "SELECT * FROM luggage";


    public List<LuggageModel> selectLuggage() {
        List<LuggageModel> luggageList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(SELECT_LUGGAGES_SQL)) {
                while (rs.next()) {
                    LuggageModel luggage = new LuggageModel();
                    luggageList.add(luggage);
                    luggage.setId(rs.getInt(1));
                    luggage.setType(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            LOG.error("Can not select luggage" , e);
            throw new RuntimeException(e);
        }
        return luggageList;
    }
}
