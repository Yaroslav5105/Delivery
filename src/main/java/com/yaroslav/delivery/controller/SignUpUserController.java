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
import javax.servlet.http.HttpSession;

@WebServlet("/SignUpUserController")
public class SignUpUserController extends HttpServlet {

    private final UserService userService = new UserService();
    private final UserService creatUserService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String email = request.getParameter("mail");
        try {
            creatUserService.createUser(new UserDto(username, password, number, email));
//            int id = userService.authenticate(email, password);
            HttpSession session = request.getSession();
            session.setAttribute("userId", 100);
            response.setCharacterEncoding("UTF-8");
            response.sendRedirect("/IndexAuthenticateUser.jsp");

        } catch (Exception e) {
            request.setAttribute("message", "Error signUpUser");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
