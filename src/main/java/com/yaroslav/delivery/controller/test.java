package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.UserService;
import com.yaroslav.delivery.validation.Validation;

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
    Validation validation = new Validation();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<OrderDto> orderDtos = orderService.findOrderSort();
//
//        for (OrderDto orderDto : orderDtos){
//            System.out.println(orderDto.getDate());
//        }
//        System.out.println("------------------------------------");


        System.out.println(validation.isCorrectEmail("erer@g"));

    }
}
