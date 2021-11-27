package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.PriceService;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewPriceController")

public class ViewPriceCommand implements Command {

    private final PriceService priceService = new PriceService();
    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setAttribute("routes", routeService.findAllRoutes());
            request.setAttribute("prices", priceService.findPrices());
            return "/price.jsp" ;
        } catch (Exception e) {
            return "error.html";
        }
    }
}