package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dao.UserDao;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@WebServlet("/OrderUserController")
public class OrderUserCommand implements Command {

    private static final java.util.logging.Logger LOG = Logger.getLogger(UserDao.class.getName());
    private final OrderService orderService = new OrderService();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        int routeId = Integer.parseInt(request.getParameter("routeId"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        try {
            orderService.createOrder(new OrderDto(userId, routeId, volume, weight, date, type));
            return "/controller?command=listOrder";
        } catch (Exception e) {
            return "error.html";
        }
    }
}