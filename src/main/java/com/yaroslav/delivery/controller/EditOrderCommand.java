package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditOrderController")
public class EditOrderCommand implements Command {

    private final RouteService routeService = new RouteService();
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pageId = Integer.parseInt(request.getParameter("page"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int routeId = Integer.parseInt(request.getParameter("routeId"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        try {
            String way = routeService.selectWay(routeId);
            orderService.updateOrder(new OrderDto(routeId, way, weight, volume, date, type, orderId));
            return "/controller?command=listOrderManager&page=" + pageId;
        } catch (Exception e) {
           return "error.html";
        }
    }
}

