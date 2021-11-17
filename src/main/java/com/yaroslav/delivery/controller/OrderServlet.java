package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.Order;
import java.io.IOException;
import java.sql.SQLException;
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
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        req.setAttribute("luggages", DBManager.findAllLuggage());
        req.setAttribute("routes", DBManager.findAllRoute());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addorder.jsp");
        requestDispatcher.forward(req, resp);
        setIdUser(Integer.parseInt(req.getParameter("id")));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        String  date = request.getParameter("date");
        String type = request.getParameter("type");
        int idRoute = Integer.parseInt(request.getParameter("idRoute"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        String payment = "not paid" ;
        try {
            DBManager.insertOrder(Order.creatOrder(idUser,idRoute,volume,weight,payment , date , type ));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/AllOrderServlet");
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
