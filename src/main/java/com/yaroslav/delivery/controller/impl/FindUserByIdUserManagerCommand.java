package com.yaroslav.delivery.controller.impl;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FindUserByIdUserManagerCommand implements Command {
    private static final Logger LOG = Logger.getLogger(FindUserByIdUserManagerCommand.class);

    private final UserService userService = new UserService();
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            if (userService.selectUser(Integer.parseInt(request.getParameter("userId"))).getId()!=null) {
                request.setAttribute("user", userService.selectUser(Integer.parseInt(request.getParameter("userId"))));
                request.setAttribute("listOrders", orderService.findAllOrdersByUserId(Integer.parseInt(request.getParameter("userId"))));
                LOG.debug("Finished executing Command");
                return "/findOrdersByUserId.jsp";
            }else return "/controller?command=ListUserManager&page=1&error=notId";
        }catch (NumberFormatException t){
            return "/controller?command=ListUserManager&page=1&error=number";
        }
        catch (Exception e) {
            LOG.error("Error in class FindUserByIdUserManagerCommand = "  , e);
            return "errorNotFoundUser.jsp";
        }
    }
}
