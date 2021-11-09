package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        String idUser = request.getParameter("idUser");
        int idRoute = Integer.parseInt(request.getParameter("idRoute"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));


        try {
            DBManager.insertOrder(Order.creatOrder(idUser ,idRoute,volume,weight));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        PrintWriter writer = response.getWriter();

        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your idRoute kilometrov is: " + idRoute + "<br/>";
        htmlRespone += "<h2>Your volume is: " + volume + "<br/>";
        htmlRespone += "<h2>Your weight is: " + weight + "<br/>";
        htmlRespone += "<h2>Your price is: " + Order.getPrice() + "<br/>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);
    }
}
