package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RouteManagerCommand implements Command {

    private final RouteService routeService = new RouteService();
    private static final Logger LOG = Logger.getLogger(RouteManagerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");
        String startingPoint = request.getParameter("a");
        String endPoint = request.getParameter("b");
        String way = startingPoint + " - " + endPoint;
        Integer kilometers = Integer.parseInt(request.getParameter("kilometers"));
        try {
            routeService.insertRoute(new RouteDto(way, kilometers));
            LOG.debug("Finished executing Command");
            return "/controller?command=ListRoute";
        } catch (Exception e) {
            LOG.error("Error in class RouteManagerCommand = "  , e);

            return "/error.html" ;
        }
    }
}
