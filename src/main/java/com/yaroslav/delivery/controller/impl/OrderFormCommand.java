package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.LuggageService;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderFormCommand implements Command {

    private final LuggageService luggageService = new LuggageService();
    private final RouteService routeService = new RouteService();
    private static final Logger LOG = Logger.getLogger(OrderFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            request.setAttribute("luggages", luggageService.findAllLuggages());
            request.setAttribute("routes", routeService.findAllRoutes());
            LOG.debug("Finished executing Command");
            return "/addOrderForUser.jsp" ;
        } catch (Exception e) {
            LOG.error("Error in class dataforOrderCommand = "  , e);
            return "error.html";
        }
    }
}
