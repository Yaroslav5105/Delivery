package com.yaroslav.delivery.controller.Date;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dataForCountOrderCommand implements Command {
    private final RouteService routeService = new RouteService();
    private static final Logger LOG = Logger.getLogger(dataForCountOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            request.setAttribute("routes", routeService.findAllRoutes());
            LOG.debug("Finished executing Command");
            return "/countOrder.jsp";
        } catch (Exception e) {
            LOG.error("Error in class dataForCountOrderCommand = "  , e);
            return "error.html";
        }
    }
}
