package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dataForEditRouteCommand implements Command {
    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setAttribute("route", routeService.selectRoute(Integer.parseInt(request.getParameter("id"))));
            request.setAttribute("idroute", Integer.parseInt(request.getParameter("id")));

            return "/routeEditForm.jsp";
        } catch (Exception e) {
            return "error.html";
        }
    }
}
