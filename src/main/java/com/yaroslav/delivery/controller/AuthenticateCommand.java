package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AuthenticateController")

public class AuthenticateCommand implements Command {

    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            int id = userService.authenticate(email, password);
            if (id != 0) {
                request.setAttribute("user", userService.selectUserByEmail(request.getParameter("email")));
            }
            HttpSession session = request.getSession();
            session.setAttribute("userId", id);

            return userService.page(id, email, password);

        } catch (Exception e) {
            return "/error.html" ;
        }
    }
}
