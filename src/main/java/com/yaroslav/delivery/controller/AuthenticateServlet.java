package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.User;
import com.yaroslav.delivery.service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthenticateServlet")

public class AuthenticateServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int id = userService.authenticate(email, password);

        if (id != 0) {
            req.setAttribute("user", userService.selectUserByEmail(req.getParameter("email")));
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(userService.page(id , email , password));
        requestDispatcher.forward(req, resp);
    }

}
