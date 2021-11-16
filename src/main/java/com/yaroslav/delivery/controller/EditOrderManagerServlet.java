package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.Order;
import com.yaroslav.delivery.db.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EditOrderManagerServlet")
public class EditOrderManagerServlet extends HttpServlet {

    private Integer id ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        this.id = id;
        List<Order> list = new ArrayList<>();
        list.add(DBManager.selectOrder(id));

        req.setAttribute("routes", DBManager.findAllRoute());
        req.setAttribute("order", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/orderEditForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");

        int id = this.id;
        Order order= DBManager.selectOrder(id);

        int idRoute = Integer.parseInt(req.getParameter("idRoute"));
        order.setIdRoute(idRoute);
        String way = dbManager.selectWay(idRoute);
        order.setWay(way);

        int weight = Integer.parseInt(req.getParameter("weight"));
        order.setWeight(weight);

        int volume = Integer.parseInt(req.getParameter("volume"));
        order.setVolume(volume);

        order.setId(id);
        try {
            DBManager.updateOrder(order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("/AllOrderServlet");
    }

}
