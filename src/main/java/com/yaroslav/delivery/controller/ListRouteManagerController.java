package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.service.RouteService;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.RequestDispatcher;
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
        try {
            req.setAttribute("Routes", routeService.findAllRoutes());
            req.getRequestDispatcher("/managerListPriceLullageRoute.jsp").forward(req, response);
        } catch (Exception e) {
            req.setAttribute("message", "Error list routes");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, response);
        }
    }
}
