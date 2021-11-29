package com.yaroslav.delivery.controller.Data;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataForEditRouteCommand implements Command {

    private final RouteService routeService = new RouteService();
    private static final Logger LOG = Logger.getLogger(DataForEditRouteCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            request.setAttribute("route", routeService.selectRoute(Integer.parseInt(request.getParameter("id"))));
            request.setAttribute("idroute", Integer.parseInt(request.getParameter("id")));
            LOG.debug("Finished executing Command");
            return "/routeEditForm.jsp";
        } catch (Exception e) {
            LOG.error("Error in class dataForEditRouteCommand = "  , e);
            return "error.html";
        }
    }
}
