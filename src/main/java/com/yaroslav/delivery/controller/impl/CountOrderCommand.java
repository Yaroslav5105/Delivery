package com.yaroslav.delivery.controller.impl;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CountOrderCommand implements Command {

    private final OrderService orderService = new OrderService();
    private static final Logger LOG = Logger.getLogger(CountOrderCommand.class);

    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOG.debug("Start executing Command");
        String page = request.getParameter("page");
        int idRoute = Integer.parseInt(request.getParameter("idRoute"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        try {
            request.setAttribute("volume", volume);
            request.setAttribute("weight", weight);
            request.setAttribute("way", routeService.selectWay(idRoute));
            request.setAttribute("count", orderService.countOrder(new OrderDto(idRoute, volume, weight)));
            LOG.debug("Finished executing Command");
            return page;
        } catch (Exception e) {
            LOG.error("Error in class CountOrderCommand = "  , e);

            return "error.html";
        }
    }
}
