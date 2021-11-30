package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderUserCommand implements Command {

    private final OrderService orderService = new OrderService();

    private static final Logger LOG = Logger.getLogger(OrderUserCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        int routeId = Integer.parseInt(request.getParameter("routeId"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        try {
            orderService.createOrder(new OrderDto(userId, routeId, volume, weight, date, type));
            LOG.debug("Finished executing Command");
            return "/controller?command=listOrder";
        } catch (Exception e) {
            LOG.error("Error in class OrderUserCommand = "  , e);

            return "error.html";
        }
    }
}