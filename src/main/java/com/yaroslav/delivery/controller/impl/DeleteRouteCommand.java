package com.yaroslav.delivery.controller.impl;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteRouteCommand implements Command {
    private static final Logger LOG = Logger.getLogger(DeleteRouteCommand.class);

    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            routeService.delete(Integer.parseInt(request.getParameter("id")));
            LOG.debug("Finished executing Command");
            return "/controller?command=ListRoute";
        } catch (Exception e) {
            LOG.error("Error in class DeleteRouteCommand = "  , e);

            return "error.html";
        }
    }
}
