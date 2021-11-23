package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.model.RouteModel;
import com.yaroslav.delivery.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteDao {

    private static final String SELECT_WAY_BY_ID = "select way from route where kilometers =?";
    private static final String SELECT_ROUTES_SQL = "SELECT * FROM route";
    private static final String DELETE_ROUTE_SQL = "delete from route where id = ?;";
    private static final String UPDATE_ROUTE_SQL = "update route set way = ?, kilometers =?  where id = ?;";
    private static final String SELECT_ROUTE_BY_ID = "select way,kilometers from route where id =?";
    private static final String INSERT_ROUTE_SQL = "INSERT INTO route (way, kilometers) VALUES (?,?);";
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

    public void deleteRoute(int id) throws SQLException {
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROUTE_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public void updateRoute(RouteModel route) throws SQLException {
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROUTE_SQL)) {
            statement.setString(1, route.getWay());
            statement.setInt(2, route.getKilometers());
            statement.setInt(3, route.getId());

            statement.executeUpdate();
        }
    }


    public RouteModel selectUser(int id) {
        RouteModel user = new RouteModel();
        try (Connection connection = dbManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROUTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String way = rs.getString("way");
                int kilometers = rs.getInt("kilometers");

                user = new RouteModel(id, way, kilometers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void insertRoute(RouteModel routeModel) throws SQLException {
        try (Connection connection = dbManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROUTE_SQL)) {

            preparedStatement.setString(1, routeModel.getWay());
            preparedStatement.setInt(2, routeModel.getKilometers());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
