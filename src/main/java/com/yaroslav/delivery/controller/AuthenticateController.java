package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.service.UserService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AuthenticateController")

public class AuthenticateController extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            int id = userService.authenticate(email, password);
            if (id != 0) {
                req.setAttribute("user", userService.selectUserByEmail(req.getParameter("email")));
            }
            HttpSession session = req.getSession();
            session.setAttribute("userId", id);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher(userService.page(id, email, password));
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Error authenticate user");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
