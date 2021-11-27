package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditUserController")
public class EditUserCommand implements Command {

    private final UserService userService = new UserService();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pageId = Integer.parseInt(request.getParameter("page"));
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("login");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        try {
            userService.updateUser(new UserDto(name, password, number, email, id));

            return "/controller?command=ListUserManager&page=" + pageId;
        } catch (Exception e) {
            return "error.html";
        }
    }
}
