package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PersonalAccountController")
public class PersonalAccountCommand implements Command {

    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            request.setAttribute("user", userService.selectUser(userId));
            return "personalAccountController.jsp";
        } catch (Exception e) {
            return "error.html";
        }
    }
}
