package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LocaleFormCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String Locale = request.getParameter("Locale");
       String adress = request.getParameter("adress");
        HttpSession session = request.getSession();
        session.setAttribute("locale", Locale);
       return adress;
    }
}
