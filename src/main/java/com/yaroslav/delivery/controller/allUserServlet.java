package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allUserServlet")
public class allUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");

        req.setAttribute("listUser", dbManager.findAllUsers());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/managerListUser.jsp");
        requestDispatcher.forward(req, response);
    }
}
