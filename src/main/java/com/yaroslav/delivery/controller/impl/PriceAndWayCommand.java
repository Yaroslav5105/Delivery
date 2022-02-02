package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PriceAndWayCommand implements Command {

    private OrderService orderService = new OrderService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int price = Integer.parseInt(request.getParameter("price"));
        String way = request.getParameter("way");
        request.setAttribute( "orders" , orderService.findAllOrderByPriceAndWay(price , way));
        return "/priceAndWay.jsp";
    }
}
