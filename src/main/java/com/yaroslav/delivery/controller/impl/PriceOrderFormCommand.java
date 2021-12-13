package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.PriceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PriceOrderFormCommand implements Command {
    private final PriceService priceService = new PriceService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {

            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                if (error.equals("wrongNumber")) {
                    request.setAttribute("errorMessage", "a warning ! only number");
                }
                if (error.equals("ok")) {
                    request.setAttribute("error", "successfully modified");
                }
            }
            request.setAttribute("prices", priceService.findPrices());
            return "/priceOrder.jsp";
        }catch (Exception e){
            return "error.jsp";
        }
    }
}