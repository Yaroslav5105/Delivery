package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditOrderCommand implements Command {
    private static final Logger LOG = Logger.getLogger(EditOrderCommand.class);

    private final RouteService routeService = new RouteService();
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int pageId = Integer.parseInt(request.getParameter("page"));

        try {
            int routeId = Integer.parseInt(request.getParameter("routeId"));
            int weight = Integer.parseInt(request.getParameter("weight"));
            int volume = Integer.parseInt(request.getParameter("volume"));
            String date = request.getParameter("date");
            String type = request.getParameter("type");

            String way = routeService.selectWay(routeId);
            orderService.updateOrder(new OrderDto(routeId, way, weight, volume, date, type, orderId));
            LOG.debug("Finished executing Command");
            return "/controller?command=listOrderManager&page=" + pageId;
        }catch (NumberFormatException e ){
            return "/controller?command=dateEditOrder&"+"id="+orderId+"&idpage="+pageId+"&error=number" ;
        }
        catch (Exception e) {
            LOG.error("Error in class EditOrderCommand = "  , e);

            return "error.html";
        }
    }
}

