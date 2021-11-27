package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.service.RouteService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditRouteCommand implements Command {
    private static final Logger LOG = Logger.getLogger(EditRouteCommand.class);

    private final RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        String way = request.getParameter("way");
        int kilometers = Integer.parseInt(request.getParameter("kilometers"));
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            routeService.update(new RouteDto(id, way, kilometers));
            LOG.debug("Finished executing Command");
            return "/controller?command=ListRoute";

        } catch (Exception e) {
            LOG.error("Error in class EditRouteCommand = "  , e);

            return "error.html";
        }
    }
}
