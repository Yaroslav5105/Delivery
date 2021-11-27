package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteRouteController")
public class DeleteRouteCommand implements Command {

    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            routeService.delete(Integer.parseInt(request.getParameter("id")));

            return "/controller?command=ListRoute";
        } catch (Exception e) {
            return "error.html";
        }
    }
}
