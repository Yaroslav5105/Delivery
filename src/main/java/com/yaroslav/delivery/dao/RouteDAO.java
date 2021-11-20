package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.Route;
import com.yaroslav.delivery.model.RouteModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteDAO {

    private static final String FIND_ALL_ROUTES = "SELECT * FROM route";
    private static final Connection connection;

    static {
        new DBManager();
        connection = DBManager.connection;
    }

    public  List<RouteModel> findAllRoute() {
        List<RouteModel> routeModels = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {

            try (ResultSet rs = ps.executeQuery(FIND_ALL_ROUTES)) {
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
}
