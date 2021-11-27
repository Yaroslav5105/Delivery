package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginUserController")
public class LoginUserCommand implements Command {

    private final UserService creatUserService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        int pageId = Integer.parseInt(request.getParameter("page"));
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String email = request.getParameter("mail");
        try {
            creatUserService.createUser(new UserDto(username, password, number, email));
            response.setCharacterEncoding("UTF-8");
            return "/controller?command=ListUserManager&page=" + pageId;
        } catch (Exception e) {
            return "error.html";
        }
    }
}