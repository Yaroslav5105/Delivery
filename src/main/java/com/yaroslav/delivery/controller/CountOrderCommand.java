package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CountOrderController")
public class CountOrderCommand implements Command {

    private final OrderService orderService = new OrderService();

    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int idRoute = Integer.parseInt(request.getParameter("idRoute"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        try {
            request.setAttribute("volume", volume);
            request.setAttribute("weight", weight);
            request.setAttribute("way", routeService.selectWay(idRoute));
            request.setAttribute("count", orderService.countOrder(new OrderDto(idRoute, volume, weight)));
            return "alreadyCountOrder.jsp";
        } catch (Exception e) {
            return "error.html";
        }
    }
}
