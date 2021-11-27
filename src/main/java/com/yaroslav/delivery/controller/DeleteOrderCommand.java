package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteOrderCommand implements Command {

    private final OrderService orderService = new OrderService();
    private static final Logger LOG = Logger.getLogger(DeleteOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        int pageId = Integer.parseInt(request.getParameter("idpage"));
        try {
            orderService.delete(Integer.parseInt(request.getParameter("id")));
            LOG.debug("Finished executing Command");
            return "/controller?command=listOrderManager&page=" + pageId ;

        } catch (Exception e) {
            LOG.error("Error in class DeleteOrderCommand = "  , e);

            e.printStackTrace();
            LOG.info("error" + e);
            return "/error.html" ;
        }
    }
}