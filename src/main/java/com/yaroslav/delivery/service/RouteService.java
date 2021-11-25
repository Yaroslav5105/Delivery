package com.yaroslav.delivery.service;


import com.yaroslav.delivery.converter.RouteConverter;
import com.yaroslav.delivery.dao.RouteDao;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.model.RouteModel;

import java.sql.SQLException;
import java.util.List;

public class RouteService {

    private final RouteDao routeDao = new RouteDao();
    private final RouteConverter routeConverter = new RouteConverter();

    public List<RouteDto> findAllRoutes() {
        return routeConverter.convertList(routeDao.selectRoutes());
    }

    public String selectWay(int i) {
        return routeDao.selectWayById(i);
    }

    public void delete(int id) {

        try {
            routeDao.deleteRoute(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(RouteDto routeDto) {
        RouteModel routeModel = new RouteModel();
        routeModel.setWay(routeDto.getWay());
        routeModel.setKilometers(routeDto.getKilometers());
        routeModel.setId(routeDto.getId());

        routeDao.updateRoute(routeModel);
    }

    public RouteDto selectRoute(int id) {
        return routeConverter.convert(routeDao.selectRoute(id));
    }

    public RouteDto insertRoute(RouteDto routeDto) {
        RouteModel routeModel = new RouteModel();
        routeModel.setWay(routeDto.getWay());
        routeModel.setKilometers(routeDto.getKilometers());
        return routeConverter.convert(routeDao.insertRoute(routeModel));
    }

}
