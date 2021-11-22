package com.yaroslav.delivery.service;


import com.yaroslav.delivery.converter.RouteConverter;
import com.yaroslav.delivery.dao.RouteDao;
import com.yaroslav.delivery.dto.RouteDto;

import java.util.List;

public class RouteService {

    private final RouteDao routeDao = new RouteDao();
    private final RouteConverter routeConverter = new RouteConverter();

    public List<RouteDto> findAllRoutes() { return routeConverter.convertList(routeDao.selectRoutes()); }

    public String selectWay(int i) {
        return routeDao.selectWayById(i);
    }
}
