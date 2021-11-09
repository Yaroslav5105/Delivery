package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws  IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        int delete = Integer.parseInt(req.getParameter("deleteorder"));
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println(DBManager.deleteOrder(delete));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your delete order is: " + delete + "<br/>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);

    }
}
