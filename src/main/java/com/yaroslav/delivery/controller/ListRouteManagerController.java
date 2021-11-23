package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.service.RouteService;
import com.yaroslav.delivery.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ListRouteManagerController")
public class ListRouteManagerController extends HttpServlet {

    private final RouteService routeService = new RouteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        req.setAttribute("Routes", routeService.findAllRoutes());
        req.getRequestDispatcher("/managerListPriceLullageRoute.jsp").forward(req, response);
    }
}
