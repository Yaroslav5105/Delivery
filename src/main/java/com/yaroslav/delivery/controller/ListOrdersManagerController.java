package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ListOrdersManagerController")
public class ListOrdersManagerController extends HttpServlet {

    private final OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        try {
            int pageid = Integer.parseInt(req.getParameter("page"));
            req.setAttribute("page", pageid);
            req.setAttribute("listOrders", orderService.findAllOrders(pageid));
            req.getRequestDispatcher("/managerListOrder.jsp").forward(req, response);
        } catch (Exception e) {
            req.setAttribute("message", "Error list orders");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, response);
        }
    }
}