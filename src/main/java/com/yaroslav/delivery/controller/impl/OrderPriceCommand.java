package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.PriceDto;
import com.yaroslav.delivery.service.PriceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderPriceCommand implements Command {
    private final PriceService priceService = new PriceService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int kilometer = Integer.parseInt(request.getParameter("kilometer"));
            int volume = Integer.parseInt(request.getParameter("volume"));
            int weight = Integer.parseInt(request.getParameter("weight"));

            priceService.updatePrice(new PriceDto(1, kilometer, volume, weight));
            return "/controller?command=formPriceOrder&error=ok";
        } catch (NumberFormatException t) {
            return "/controller?command=formPriceOrder&error=wrongNumber";
        } catch (Exception e) {
            return "error.jsp";
        }
    }
}
