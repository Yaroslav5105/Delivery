package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.PriceService;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewPriceCommand implements Command {

    private final PriceService priceService = new PriceService();
    private final RouteService routeService = new RouteService();
    private static final Logger LOG = Logger.getLogger(ViewPriceCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");
        try {
            request.setAttribute("routes", routeService.findAllRoutes());
            request.setAttribute("prices", priceService.findPrices());
            LOG.debug("Finished executing Command");
            return "/price.jsp" ;
        } catch (Exception e) {
            LOG.error("Error in class ViewPriceCommand = "  , e);
            return "error.html";
        }
    }
}