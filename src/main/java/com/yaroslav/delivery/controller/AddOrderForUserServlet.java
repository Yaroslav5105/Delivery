package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/AddOrderForUserServlet")
public class AddOrderForUserServlet extends HttpServlet {
    private int idUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        req.setAttribute("luggages", DBManager.findAllLuggage());
        req.setAttribute("routes", DBManager.findAllRoute());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addOrderForUser.jsp");
        requestDispatcher.forward(req, resp);
        setIdUser(AuthenticateServlet.getId());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");
        String type = request.getParameter("type");
        String  date = request.getParameter("date");
        int idRoute = Integer.parseInt(request.getParameter("idRoute"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        String payment = "not paid" ;
        try {
            DBManager.insertOrder(Order.creatOrder(idUser,idRoute,volume,weight,payment , date , type));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/UserListOrderServlet");
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
