package com.yaroslav.delivery.controller.Data;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.LuggageService;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataForEditOrderCommand implements Command {
    private static final Logger LOG = Logger.getLogger(DataForEditOrderCommand.class);

    private final LuggageService luggageService = new LuggageService();
    private final RouteService routeService = new RouteService();
    private final OrderService orderService = new OrderService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        request.setAttribute("pageId", Integer.parseInt(request.getParameter("idpage")));

        try {
            request.setAttribute("order", orderService.selectOrder(Integer.parseInt(request.getParameter("id"))));

            request.setAttribute("luggages", luggageService.findAllLuggages());
            request.setAttribute("routes", routeService.findAllRoutes());
            LOG.debug("Finished executing Command");
            return "/orderEditForm.jsp";
        } catch (Exception e) {
            LOG.error("Error in class dataForEditOrderCommand = "  , e);
            return "error.html";
        }
    }
}
