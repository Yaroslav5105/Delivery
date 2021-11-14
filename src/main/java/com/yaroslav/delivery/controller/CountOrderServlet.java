package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/CountOrderServlet")
public class CountOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");

        int idRoute = Integer.parseInt(req.getParameter("idRoute"));
        int volume = Integer.parseInt(req.getParameter("volume"));
        int weight = Integer.parseInt(req.getParameter("weight"));

        int count = 0;
        count = (volume + weight) * 2 + idRoute * 4;

        req.setAttribute("count", count);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/countOrder.jsp");
        requestDispatcher.forward(req, response);


    }
}
