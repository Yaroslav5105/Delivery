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

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private int idUser;

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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addorder.jsp");
        requestDispatcher.forward(req, resp);

         setIdUser(Integer.parseInt(req.getParameter("id")));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        int idRoute = Integer.parseInt(request.getParameter("idRoute"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));

        try {
            DBManager.insertOrder(Order.creatOrder(idUser,idRoute,volume,weight));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/AllOrderServlet");
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
