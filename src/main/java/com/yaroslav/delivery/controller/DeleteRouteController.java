package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.service.RouteService;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteRouteController")
public class DeleteRouteController extends HttpServlet {

    private final RouteService routeService = new RouteService();

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {

        routeService.delete(Integer.parseInt(req.getParameter("id")));
        response.sendRedirect("/ListRouteManagerController");

    }
}
