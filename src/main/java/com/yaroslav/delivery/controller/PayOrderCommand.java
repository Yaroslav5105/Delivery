package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PayOrderController")

public class PayOrderCommand implements Command {

    private final OrderService orderServlet = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            orderServlet.payment(new OrderDto(Integer.parseInt(request.getParameter("id"))));
            return "/controller?command=listOrder";
        } catch (Exception e) {
            return "error.html";
        }
    }
}