package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ListOrderUserController")
public class ListOrderUserCommand implements Command {

    private final OrderService orderService = new OrderService();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");

            request.setAttribute("listOrders", orderService.findAllOrdersByUserId(userId));
            return "/userListOrder.jsp";
        }catch (Exception e){
            return "error.html";
        }
    }
}
