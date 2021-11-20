package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PayOrderServlet")

public class PayOrderServlet extends  HttpServlet{

    OrderService orderServlet = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int iduser = AuthenticateServlet.getId();
        int id = Integer.parseInt(request.getParameter("id"));
        orderServlet.payment(new OrderDto(id , iduser));
        response.sendRedirect("/UserListOrderServlet");
    }
}
