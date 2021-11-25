package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.LuggageService;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/OrderUserController")
public class OrderUserController extends HttpServlet {

    private final LuggageService luggageService = new LuggageService();
    private final OrderService orderService = new OrderService();
    private final RouteService routeService = new RouteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("luggages", luggageService.findAllLuggages());
            req.setAttribute("routes", routeService.findAllRoutes());
            req.getRequestDispatcher("/addOrderForUser.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Error find all routes or luggage");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        int routeId = Integer.parseInt(request.getParameter("routeId"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        try {
            orderService.createOrder(new OrderDto(userId, routeId, volume, weight, date, type));
            response.sendRedirect("/ListOrderUserController");
        } catch (Exception e) {
            request.setAttribute("message", "Error creat order by user");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}