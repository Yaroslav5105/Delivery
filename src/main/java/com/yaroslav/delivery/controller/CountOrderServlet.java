package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/CountOrderServlet")
public class CountOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Integer> routes = new HashMap<>();
        routes.put("Kharkiv - Poltava", 140);
        routes.put("Kharkiv - Kyiv", 480);
        routes.put("Kharkiv - Dnipro", 210);
        routes.put("Kharkiv - Vinnitsa", 705);
        routes.put("Kharkiv - Lviv", 1010);
        routes.put("Kharkiv - Ivano-Frankivsk", 1080);
        routes.put("Kharkiv - Sumy", 180);
        req.setAttribute("routes", routes);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/countOrder.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");

        int idRoute = Integer.parseInt(req.getParameter("idRoute"));
        int volume = Integer.parseInt(req.getParameter("volume"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        int count ;

        count = (volume + weight) * 2 + idRoute * 4;

        req.setAttribute("count", count);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/countOrder.jsp");
        requestDispatcher.forward(req, response);
    }
}
