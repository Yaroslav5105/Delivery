package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class test extends HttpServlet {

    OrderService orderService = new OrderService();
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        int userId = (int) session.getAttribute("userId");
//        System.out.println(userId   );
//        session.removeAttribute("userId");
//        int userId2 = (int) session.getAttribute("userId");
//        System.out.println(userId2);

        OrderDto orderDto = orderService.findUserByIdOrder(200);

        System.out.println(orderDto.getId());
        System.out.println(userService.selectUser(orderDto.getIdUser()).getLogin());
    }
}
