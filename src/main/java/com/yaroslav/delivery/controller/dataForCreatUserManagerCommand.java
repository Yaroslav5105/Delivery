package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dataForCreatUserManagerCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setAttribute("pageId", Integer.parseInt(request.getParameter("idpage")));
            return "/adduser.jsp";
        } catch (Exception e) {
            return "error.html";
        }
    }
}