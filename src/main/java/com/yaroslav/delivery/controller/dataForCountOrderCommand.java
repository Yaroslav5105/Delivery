package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dataForCountOrderCommand implements Command {
    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setAttribute("routes", routeService.findAllRoutes());
            return "/countOrder.jsp";
        } catch (Exception e) {
            return "error.html";
        }
    }
}
