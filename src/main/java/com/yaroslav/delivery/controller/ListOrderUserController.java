package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ListOrderUserController")
public class ListOrderUserController extends HttpServlet {

    private final OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId");

        req.setAttribute("listOrders", orderService.findAllOrdersByUserId(userId));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userListOrder.jsp");
        requestDispatcher.forward(req, response);
    }
}
