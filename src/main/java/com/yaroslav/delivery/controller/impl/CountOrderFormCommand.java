package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountOrderFormCommand implements Command {
    private final RouteService routeService = new RouteService();
    private static final Logger LOG = Logger.getLogger(CountOrderFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {

            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                if (error.equals("wrongNumber")) {
                    request.setAttribute("errorMessage", "a warning ! only numbers");
                }
            }
            LOG.debug("Start executing Command");
            String page = request.getParameter("page");
            request.setAttribute("routes", routeService.findAllRoutes());
            LOG.debug("Finished executing Command");
            return page;
        } catch (Exception e) {
            LOG.error("Error in class dataForCountOrderCommand = "  , e);
            return "error.html";
        }
    }
}
