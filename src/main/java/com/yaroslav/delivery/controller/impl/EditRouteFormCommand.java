package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditRouteFormCommand implements Command {

    private final RouteService routeService = new RouteService();
    private static final Logger LOG = Logger.getLogger(EditRouteFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                if (error.equals("kilometer")) {
                    request.setAttribute("errorMessage", "a warning ! only numbers in kilometer");
                }

            }

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
