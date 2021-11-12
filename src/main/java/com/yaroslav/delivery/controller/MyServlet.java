package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        int delete = Integer.parseInt(req.getParameter("id"));
        response.setContentType("text/html");
        try {
            DBManager.deleteUser(delete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/managerListUser.jsp");
    }
}