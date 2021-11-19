package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private final UserService creatUserService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String email = request.getParameter("mail");

        creatUserService.createUser(new UserDto(username , password , number , email));

        response.sendRedirect("/allUserServlet");
    }
}