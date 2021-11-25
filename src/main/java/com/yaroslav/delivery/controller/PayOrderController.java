package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PayOrderController")

public class PayOrderController extends HttpServlet {

    private final OrderService orderServlet = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("orderId", Integer.parseInt(request.getParameter("id")));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/paymentOrder.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            orderServlet.payment(new OrderDto(Integer.parseInt(req.getParameter("id"))));
            resp.sendRedirect("/ListOrderUserController");
        } catch (Exception e) {
            req.setAttribute("message", "Error payment");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}