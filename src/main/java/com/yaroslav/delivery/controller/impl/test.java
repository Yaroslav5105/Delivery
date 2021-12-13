package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.dto.PriceDto;
import com.yaroslav.delivery.service.PriceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class test extends HttpServlet {
    private final PriceService priceService = new PriceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        priceService.updatePrice(new PriceDto(1 ,11,111 , 1111));

    }
}
