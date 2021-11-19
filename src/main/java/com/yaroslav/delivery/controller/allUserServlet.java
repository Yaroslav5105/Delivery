package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.service.UserService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allUserServlet")
public class allUserServlet extends HttpServlet {

    private final UserService creatUserService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        req.setAttribute("listUser", creatUserService.findAllUser());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/managerListUser.jsp");
        requestDispatcher.forward(req, response);
    }
}