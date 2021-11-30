package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SortDateFromLargerCommand implements Command {
    private final OrderService orderService = new OrderService();
    private static final Logger LOG = Logger.getLogger(SortDateFromLargerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");
        try {
            int pageid = Integer.parseInt(request.getParameter("page"));
            request.setAttribute("page", pageid);
            request.setAttribute("sort" , orderService.findOrderFromLargerSort(pageid));
            LOG.debug("Finished executing Command");
            return "sortDateFromLarger.jsp" ;
        } catch (Exception e) {
            return "error.html";
        }
    }
}
