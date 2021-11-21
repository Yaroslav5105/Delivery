package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserListOrderServlet")
public class UserListOrderServlet extends HttpServlet {

    OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        req.setAttribute("listOrder", orderService.findAllOrderByUserId(userId));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userListOrder.jsp");
        requestDispatcher.forward(req, response);
    }
}
