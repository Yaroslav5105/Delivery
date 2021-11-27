package com.yaroslav.delivery.controller;



import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/findOrderByIdOrderManagerCommand")
public class FindOrderByIdOrderManagerCommand implements Command {

    private final UserService userService = new UserService();
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            OrderDto orderDto = orderService.findUserByIdOrder(Integer.parseInt(request.getParameter("userId")));
            request.setAttribute("order", orderDto);
            request.setAttribute("user", userService.selectUser(orderDto.getIdUser()));
            return userService.pageDataOrder(orderDto.getIdUser());

        } catch (Exception e) {
            return "error.html";
        }
    }
}
