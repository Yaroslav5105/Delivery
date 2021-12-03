package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GoOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        return "index.jsp";
    }
}
