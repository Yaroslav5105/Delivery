package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.service.UserService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteUserController")
public class DeleteUserController extends HttpServlet {

    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.delete(id);
        response.sendRedirect("/ListUsersManagerController");
    }
}
