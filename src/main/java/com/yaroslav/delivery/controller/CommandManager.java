package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CommandManager  {

    private static final java.util.logging.Logger LOG = Logger.getLogger(CommandManager.class.getName());
    private static Map<String, Command> commands = new HashMap<String, Command>();

    static {

        commands.put("creatUser", new SignUpUserCommand());
        commands.put("authenticate", new AuthenticateCommand());
        commands.put("insertRoute", new RouteManagerCommand());
        commands.put("listOrder", new ListOrderUserCommand());
        commands.put("dataCountOrder" , new dataForCountOrderCommand());
        commands.put("countOrder" , new CountOrderCommand());
        commands.put("dataForOrder" , new dataforOrderCommand());
        commands.put("orderUser" , new OrderUserCommand());
        commands.put("dataPayment" , new dataPaymentCommand());
        commands.put("PayOrder" , new PayOrderCommand());
        commands.put("price" , new ViewPriceCommand());
        commands.put("personAccount" , new PersonalAccountCommand());

        commands.put("listOrderManager" , new ListOrdersManagerCommand());
        commands.put("dateEditOrder" , new dataForEditOrderCommand());
        commands.put("deleteOrder", new DeleteOrderCommand());
        commands.put("editOrder", new EditOrderCommand());
        commands.put("findOrderforIdOrder", new FindOrderByIdOrderManagerCommand());

        commands.put("ListUserManager", new ListUsersManagerCommand());
        commands.put("deleteUser", new DeleteUserCommand());
        commands.put("dateForEditUser", new dataForEditUserCommand());
        commands.put("editUser", new EditUserCommand());
        commands.put("dateOrderManager", new dataforOrderManagerCommand());
        commands.put("orderManager", new OrderManagerCommand());
        commands.put("dateForInsertUser", new dataForCreatUserManagerCommand());
        commands.put("insertUser", new LoginUserCommand());
        commands.put("findUser", new FindUserByIdUserManagerCommand());

        commands.put("ListRoute", new ListRouteManagerCommand());
        commands.put("dataEditRoute", new dataForEditRouteCommand());
        commands.put("editRoute", new EditRouteCommand());
        commands.put("deleteRoute", new DeleteRouteCommand());


    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.info("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
