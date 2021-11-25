package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ListUsersManagerController")
public class ListUsersManagerController extends HttpServlet {

    private final UserService findAllUsers = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        try {
            int pageid = Integer.parseInt(req.getParameter("page"));
            req.setAttribute("page", pageid);
            req.setAttribute("listUsers", findAllUsers.findAllUsers(pageid));
            req.getRequestDispatcher("/managerListUser.jsp").forward(req, response);
        } catch (Exception e) {
            req.setAttribute("message", "Error list users");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, response);
        }
    }
}