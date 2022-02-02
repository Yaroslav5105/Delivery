package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PriceAndWayForm implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/priceAndWayForm.jsp";
    }
}
