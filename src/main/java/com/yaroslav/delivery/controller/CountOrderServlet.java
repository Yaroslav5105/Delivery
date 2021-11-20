package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
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


@WebServlet("/CountOrderServlet")
public class CountOrderServlet extends HttpServlet {

    OrderService orderService = new OrderService();
    RouteService routeService = new RouteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("routes", routeService.findAllRoute());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/countOrder.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {


        int idRoute = Integer.parseInt(req.getParameter("idRoute"));
        int volume = Integer.parseInt(req.getParameter("volume"));
        int weight = Integer.parseInt(req.getParameter("weight"));

        req.setAttribute("count", orderService.countOrder(new OrderDto(idRoute, volume, weight)));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/countOrder.jsp");
        requestDispatcher.forward(req, response);
    }
}
