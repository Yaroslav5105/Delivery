package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteUserController")
public class DeleteUserController extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        int pageId = Integer.parseInt(req.getParameter("idpage"));
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            userService.delete(id);
            response.sendRedirect("/ListUsersManagerController?page=" + pageId);
        } catch (Exception e) {
            req.setAttribute("message", "Error delete User");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, response);
        }
    }
}
