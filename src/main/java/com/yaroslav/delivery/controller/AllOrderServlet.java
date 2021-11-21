package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.service.OrderService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AllOrderServlet")
public class AllOrderServlet extends HttpServlet {

    OrderService findAllOrderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        req.setAttribute("listOrder", findAllOrderService.findAllOrder());
        req.getRequestDispatcher("/managerListOrder.jsp").forward(req, response);
    }
}
