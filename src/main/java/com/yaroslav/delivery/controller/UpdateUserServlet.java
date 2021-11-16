package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = EditUserManagerServlet.getId();

        User user = DBManager.selectUser(id);

        String name = req.getParameter("login");
        user.setLogin(name);

        String password = req.getParameter("password");
        user.setPassword(password);

        String number = req.getParameter("number");
        user.setNumber(number);

        String email = req.getParameter("email");
        user.setMail(email);

        user.setId(id);
        try {
            DBManager.updateUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("/allUserServlet");
    }
}
