package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.service.PriceService;
import com.yaroslav.delivery.service.RouteService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewPriceController")

public class ViewPriceController extends HttpServlet {

    private final PriceService priceService = new PriceService();
    private final RouteService routeService = new RouteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("routes", routeService.findAllRoutes());
        req.setAttribute("prices", priceService.findPrices());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/price.jsp");
        requestDispatcher.forward(req, resp);
    }
}
