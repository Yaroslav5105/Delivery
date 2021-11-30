package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class PayOrderCommand implements Command {

    private final OrderService orderServlet = new OrderService();
    private static final Logger LOG = Logger.getLogger(PayOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            orderServlet.payment(new OrderDto(Integer.parseInt(request.getParameter("id"))));
            LOG.debug("Finished executing Command");
            return "/controller?command=listOrder";
        } catch (Exception e) {
            LOG.error("Error in class PayOrderCommand = "  , e);

            return "error.html";
        }
    }
}