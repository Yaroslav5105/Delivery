package com.yaroslav.delivery.converter;

import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.model.RouteModel;

import java.util.ArrayList;
import java.util.List;


public class RouteConverter implements ConverterList<RouteModel , RouteDto>{

    @Override
    public List<RouteDto> convertList(List<RouteModel> source) {
        List<RouteDto> routeDtos = new ArrayList<>();
        for (RouteModel routeModel : source) {
            RouteDto routeDto = new RouteDto();
            routeDtos.add(routeDto);
            routeDto.setId(routeModel.getId());
            routeDto.setWay(routeModel.getWay());
            routeDto.setKilometers(routeModel.getKilometers());
        }
        return routeDtos;
    }
}
