package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/CountOrderController")
public class CountOrderController extends HttpServlet {

    private final OrderService orderService = new OrderService();
    private final RouteService routeService = new RouteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("routes", routeService.findAllRoutes());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/countOrder.jsp");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Error find all routes");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {

        int idRoute = Integer.parseInt(req.getParameter("idRoute"));
        int volume = Integer.parseInt(req.getParameter("volume"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        try {
            req.setAttribute("count", orderService.countOrder(new OrderDto(idRoute, volume, weight)));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/countOrder.jsp");
            requestDispatcher.forward(req, response);
        } catch (Exception e) {
            req.setAttribute("message", "Error count order");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, response);
        }
    }
}
