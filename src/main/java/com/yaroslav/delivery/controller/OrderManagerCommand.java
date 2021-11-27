package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderManagerController")
public class OrderManagerCommand implements Command {

    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        int id = Integer.parseInt(request.getParameter("id"));
        int routeId = Integer.parseInt(request.getParameter("routeId"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        try {
            orderService.createOrder(new OrderDto(id, routeId, volume, weight, date, type));

            return "/controller?command=listOrderManager&page=1";
        } catch (Exception e) {
            return "error.html";
        }
    }
}

