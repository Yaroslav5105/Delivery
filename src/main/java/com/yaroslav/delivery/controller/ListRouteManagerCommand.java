package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListRouteManagerController")
public class ListRouteManagerCommand implements Command {

    private final RouteService routeService = new RouteService();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setAttribute("Routes", routeService.findAllRoutes());
            return "/managerListPriceLullageRoute.jsp" ;
        } catch (Exception e) {
           return "error.html";
        }
    }
}
