package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.service.OrderService;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteOrderController")
public class DeleteOrderController extends HttpServlet {

    private final OrderService orderService = new OrderService();

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {

        orderService.delete(Integer.parseInt(req.getParameter("id")));
        response.sendRedirect("/ListOrdersManagerController");

    }
}
