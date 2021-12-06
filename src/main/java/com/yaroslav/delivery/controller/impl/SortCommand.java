package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SortCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            String page = request.getParameter("page");

            if (page.equals("sortDate")) {
                return "/controller?command=sortDate&page=1";
            }
            if (page.equals("Large")) {
                return "/controller?command=sortDateForLarge&page=1";
            }
            if (page.equals("list")) {
                return "/controller?command=listOrderManager&page=1";
            }
            if (page.equals("sortMin")) {
                return "/controller?command=sortIdUserForLarger&page=1";
            }
            if (page.equals("sortMax")) {
                return "//controller?command=ListUserManager&page=1";
            }
            return "error.html";
        }catch (Exception e){
            return "error.html";
        }
    }
}
