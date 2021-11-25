package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.UserService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FindOrdersByUserManagerController")
public class FindOrdersByUserManagerController extends HttpServlet {

    private final UserService userService = new UserService();
    private final OrderService orderService = new OrderService();

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.setAttribute("user", userService.selectUser(Integer.parseInt(request.getParameter("userId"))));
            request.setAttribute("listOrders", orderService.findAllOrdersByUserId(Integer.parseInt(request.getParameter("userId"))));

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(userService.pageDataUser(Integer.parseInt(request.getParameter("userId"))));
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("message", "Error find user or order");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}
