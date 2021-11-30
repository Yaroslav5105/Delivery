package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.LuggageService;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderManagerFormCommand implements Command {

    private final LuggageService luggageService = new LuggageService();
    private final RouteService routeService = new RouteService();
    private static final Logger LOG = Logger.getLogger(OrderManagerFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            request.setAttribute("user", Integer.parseInt(request.getParameter("id")));
            request.setAttribute("luggages", luggageService.findAllLuggages());
            request.setAttribute("routes", routeService.findAllRoutes());
           return "/addorder.jsp" ;
        } catch (Exception e) {
            LOG.error("Error in class dataforOrderManagerCommand = "  , e);

            return  "error.html";
        }
    }
}
