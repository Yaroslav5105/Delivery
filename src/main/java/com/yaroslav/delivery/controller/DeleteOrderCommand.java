package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dao.OrderDao;
import com.yaroslav.delivery.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteOrderController")
public class DeleteOrderCommand implements Command {

    private final OrderService orderService = new OrderService();
    private static final Logger LOG = Logger.getLogger(OrderDao.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pageId = Integer.parseInt(request.getParameter("idpage"));
        try {
            orderService.delete(Integer.parseInt(request.getParameter("id")));
            return "/controller?command=listOrderManager&page=" + pageId ;

        } catch (Exception e) {
            e.printStackTrace();
            LOG.info("error" + e);
            return "/error.html" ;
        }
    }
}