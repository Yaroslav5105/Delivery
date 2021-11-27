package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RouteManagerController")
public class RouteManagerCommand implements Command {

    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String startingPoint = request.getParameter("a");
        String endPoint = request.getParameter("b");
        String way = startingPoint + " - " + endPoint;
        Integer kilometers = Integer.parseInt(request.getParameter("kilometers"));
        try {
            routeService.insertRoute(new RouteDto(way, kilometers));
            return "/controller?command=ListRoute";
        } catch (Exception e) {
            return "/error.html" ;
        }
    }
}
