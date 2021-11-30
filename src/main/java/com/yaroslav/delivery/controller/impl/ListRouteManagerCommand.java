package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListRouteManagerCommand implements Command {

    private final RouteService routeService = new RouteService();
    private static final Logger LOG = Logger.getLogger(ListRouteManagerCommand.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            request.setAttribute("Routes", routeService.findAllRoutes());
            LOG.debug("Finished executing Command");
            return "/managerListPriceLullageRoute.jsp" ;
        } catch (Exception e) {
            LOG.error("Error in class ListRouteManagerCommand = "  , e);

            return "error.html";
        }
    }
}
