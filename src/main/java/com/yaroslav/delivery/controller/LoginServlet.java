package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");

        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String mail = request.getParameter("mail");

        try {
            DBManager.insertUser(User.createUser(username ,password , number , mail));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/allUserServlet");
    }
}