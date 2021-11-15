package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthenticateServlet")

public class AuthenticateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher  = getServletConfig().getServletContext().getRequestDispatcher("/maneger");
        requestDispatcher.forward(req , resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        response.setContentType("text/html");

        String name = null;

        try {
            name = DBManager.authenticate(email, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(email.equals("admin@gmail.com")){
            if (password.equals("12345"))
                response.sendRedirect("maneger.jsp");
        }else if (name != null) {
            response.sendRedirect("IndexAuthenticateUser.jsp");
        }

    }
}
