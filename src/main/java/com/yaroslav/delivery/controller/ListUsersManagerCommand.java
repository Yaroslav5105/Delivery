package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListUsersManagerController")
public class ListUsersManagerCommand implements Command {

    private final UserService findAllUsers = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int pageid = Integer.parseInt(request.getParameter("page"));
            request.setAttribute("page", pageid);
            request.setAttribute("listUsers", findAllUsers.findAllUsers(pageid));
            return "/managerListUser.jsp";
        } catch (Exception e) {
            return "error.html";
        }
    }
}