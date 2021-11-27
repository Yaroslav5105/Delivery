package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dataForEditUserCommand implements Command {
    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setAttribute("pageId", Integer.parseInt(request.getParameter("idpage")));
            request.setAttribute("user", userService.selectUser(Integer.parseInt(request.getParameter("id"))));
            return "/userEditForm.jsp" ;
        } catch (Exception e) {
            return "error.html";
        }
    }
}
