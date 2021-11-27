package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteUserController")
public class DeleteUserCommand implements Command {

    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pageId = Integer.parseInt(request.getParameter("idpage"));
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userService.delete(id);

            return "/controller?command=ListUserManager&page=" + pageId;
        } catch (Exception e) {
            return "error.html";
        }
    }
}
