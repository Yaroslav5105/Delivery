package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.LuggageService;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dataForEditOrderCommand implements Command {

    private final LuggageService luggageService = new LuggageService();
    private final RouteService routeService = new RouteService();
    private final OrderService orderService = new OrderService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("pageId", Integer.parseInt(request.getParameter("idpage")));

        try {
            request.setAttribute("order", orderService.selectOrder(Integer.parseInt(request.getParameter("id"))));

            request.setAttribute("luggages", luggageService.findAllLuggages());
            request.setAttribute("routes", routeService.findAllRoutes());

            return "/orderEditForm.jsp";
        } catch (Exception e) {
            return "error.html";
        }
    }
}
