package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditRouteController")
public class EditRouteCommand implements Command {

    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String way = request.getParameter("way");
        int kilometers = Integer.parseInt(request.getParameter("kilometers"));
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            routeService.update(new RouteDto(id, way, kilometers));

            return "/controller?command=ListRoute";
        } catch (Exception e) {
            return "error.html";
        }
    }
}
