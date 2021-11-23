package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.service.RouteService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RouteManagerController")
public class RouteManagerController extends HttpServlet {

    private final RouteService routeService = new RouteService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String startingPoint = req.getParameter("a");
        String endPoint = req.getParameter("b");
        String way = startingPoint+" - "+endPoint;
        Integer kilometers = Integer.parseInt(req.getParameter("kilometers"));
        routeService.insertRoute(new RouteDto(way , kilometers));
        resp.sendRedirect("/ListRouteManagerController");

    }
}
