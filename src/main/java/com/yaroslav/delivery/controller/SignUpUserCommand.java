package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SignUpUserController")
public class SignUpUserCommand implements Command {

    private final UserService userService = new UserService();
    private final UserService creatUserService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("cp1251");
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String email = request.getParameter("mail");
        try {
            creatUserService.createUser(new UserDto(username, password, number, email));
            int id = userService.authenticate(email, password);
            HttpSession session = request.getSession();
            session.setAttribute("userId", id);
            return "/IndexAuthenticateUser.jsp";

        } catch (Exception e) {
            return "/error.html" ;
        }
    }
}
