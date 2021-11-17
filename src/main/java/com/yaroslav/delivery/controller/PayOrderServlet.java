package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.Order;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PayOrderServlet")

public class PayOrderServlet extends  HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        int iduser = AuthenticateServlet.getId();
        int id = Integer.parseInt(request.getParameter("id"));

        Order order= DBManager.selectOrder(iduser);
        order.setId(id);
        order.setPayment("successful payment");
        try {
            DBManager.updateOrderPayment(order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/UserListOrderServlet");
    }

}
