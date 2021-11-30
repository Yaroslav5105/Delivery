package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListOrderUserCommand implements Command {

    private final OrderService orderService = new OrderService();
    private static final Logger LOG = Logger.getLogger(ListOrderUserCommand.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");

            request.setAttribute("listOrders", orderService.findAllOrdersByUserId(userId));
            LOG.debug("Finished executing Command");
            return "/userListOrder.jsp";
        }catch (Exception e){
            LOG.error("Error in class ListOrderUserCommand = "  , e);

            return "error.html";
        }
    }
}
