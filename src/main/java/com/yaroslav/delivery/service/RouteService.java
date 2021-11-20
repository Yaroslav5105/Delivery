package com.yaroslav.delivery.service;


import com.yaroslav.delivery.dao.RouteDAO;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.model.RouteModel;

import java.util.ArrayList;
import java.util.List;

public class RouteService {

    RouteDAO routeDAO = new RouteDAO();

    public List<RouteDto> findAllRoute() {

        List<RouteDto> routeDtos = new ArrayList<>();

        List<RouteModel> routeModels = routeDAO.findAllRoute();
        for (RouteModel routeModel : routeModels) {
            RouteDto routeDto = new RouteDto();
            routeDtos.add(routeDto);
            routeDto.setId(routeModel.getId());
            routeDto.setWay(routeModel.getWay());
            routeDto.setKilometers(routeModel.getKilometers());

        }
        return routeDtos;
    }
}
