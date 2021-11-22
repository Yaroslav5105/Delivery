package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.model.RouteModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteDao {

    private static final String SELECT_WAY_BY_ID = "select way from route where kilometers =?";
    private static final String SELECT_ROUTES_SQL = "SELECT * FROM route";
    private static final DBManager dbManager = new DBManager();


    public  List<RouteModel> selectRoutes() {
        List<RouteModel> routeModels = new ArrayList<>();
        try (Connection connection = dbManager.getConnection();
             Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(SELECT_ROUTES_SQL)) {
                while (rs.next()) {
                    RouteModel route = new RouteModel();
                    routeModels.add(route);
                    route.setId(rs.getInt(1));
                    route.setKilometers(rs.getInt(2));
                    route.setWay(rs.getString(3));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return routeModels;
    }
    public String selectWayById(int id) {
        String idUser = "";
        try (Connection connection = dbManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WAY_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                idUser = rs.getString("way");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUser;
    }
}
