package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentFormCommand implements Command {
    private static final Logger LOG = Logger.getLogger(PaymentFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            request.setAttribute("orderId", Integer.parseInt(request.getParameter("id")));
            LOG.debug("Finished executing Command");
            return "/paymentOrder.jsp";
        }catch (Exception e ){
            LOG.error("Error in class dataPaymentCommand = "  , e);

            return "error.html";
        }
    }
}
