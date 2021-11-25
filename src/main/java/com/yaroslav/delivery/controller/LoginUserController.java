package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginUserController")
public class LoginUserController extends HttpServlet {

    private final UserService creatUserService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageId", Integer.parseInt(req.getParameter("idpage")));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/adduser.jsp");
        requestDispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int pageId = Integer.parseInt(request.getParameter("page"));
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String email = request.getParameter("mail");
        try {
            creatUserService.createUser(new UserDto(username, password, number, email));
            response.setCharacterEncoding("UTF-8");
            response.sendRedirect("/ListUsersManagerController?page=" + pageId);
        } catch (Exception e) {
            request.setAttribute("message", "Error login user");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}