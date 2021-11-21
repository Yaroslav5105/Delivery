package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.LuggageService;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    LuggageService luggageService = new LuggageService();
    OrderService orderService = new OrderService();
    RouteService routeService = new RouteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user" , Integer.parseInt(req.getParameter("id")));
        req.setAttribute("luggages", luggageService.findAllLuggage());
        req.setAttribute("routes", routeService.findAllRoute());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addorder.jsp");
        requestDispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String date = request.getParameter("date");
        String type = request.getParameter("type");
        int id = Integer.parseInt(request.getParameter("id"));
        int idRoute = Integer.parseInt(request.getParameter("idRoute"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));

        orderService.createOrder(new OrderDto(id, idRoute, volume, weight, date, type));

        response.sendRedirect("/AllOrderServlet");
    }
}

