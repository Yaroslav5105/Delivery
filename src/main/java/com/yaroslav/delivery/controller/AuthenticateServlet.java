package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthenticateServlet")

public class AuthenticateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String name = null;
        try {
            name= DBManager.authenticate(email, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your name  is: " + name + "<br/>";
        htmlRespone += "<h2>Your email  is: " + email + "<br/>";
        htmlRespone += "<h2>Your password  is: " + password + "<br/>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);

    }
}
