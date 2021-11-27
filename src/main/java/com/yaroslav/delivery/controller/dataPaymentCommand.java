package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dataPaymentCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setAttribute("orderId", Integer.parseInt(request.getParameter("id")));
            return "/paymentOrder.jsp";
        }catch (Exception e ){
            return "error.html";
        }
    }
}
