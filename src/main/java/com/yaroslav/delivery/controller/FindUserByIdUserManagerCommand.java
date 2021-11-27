package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FindOrdersByUserManagerController")
public class FindUserByIdUserManagerCommand implements Command {

    private final UserService userService = new UserService();
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setAttribute("user", userService.selectUser(Integer.parseInt(request.getParameter("userId"))));
            request.setAttribute("listOrders", orderService.findAllOrdersByUserId(Integer.parseInt(request.getParameter("userId"))));

            return userService.pageDataUser(Integer.parseInt(request.getParameter("userId")));
        } catch (Exception e) {
            return "error.html";
        }
    }
}
