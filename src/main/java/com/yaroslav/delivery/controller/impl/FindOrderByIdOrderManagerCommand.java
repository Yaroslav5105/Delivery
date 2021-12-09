package com.yaroslav.delivery.controller.impl;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/findOrderByIdOrderManagerCommand")
public class FindOrderByIdOrderManagerCommand implements Command {
    private static final Logger LOG = Logger.getLogger(FindOrderByIdOrderManagerCommand.class);

    private final UserService userService = new UserService();
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            OrderDto orderDto = orderService.findUserByIdOrder(Integer.parseInt(request.getParameter("userId")));
            if (orderDto.getId() != null) {
                request.setAttribute("order", orderDto);
                request.setAttribute("user", userService.selectUser(orderDto.getIdUser()));
                LOG.debug("Finished executing Command");
                return "/findOrder.jsp";
            } else return "/controller?command=listOrderManager&page=1&error=notId";
        } catch (NumberFormatException e) {
            return "/controller?command=listOrderManager&page=1&error=number";
        } catch (Exception e) {
            LOG.error("Error in class dataForEditUserCommand = ", e);
            return "errorNotFoundUser.jsp";
        }
    }
}
