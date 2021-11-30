package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.controller.impl.*;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static final Logger LOG = Logger.getLogger(CommandManager.class);
    private static Map<String, Command> commands = new HashMap<String, Command>();

    static {

        commands.put("creatUser", new SignUpUserCommand());
        commands.put("authenticate", new AuthenticateCommand());
        commands.put("insertRoute", new RouteManagerCommand());
        commands.put("listOrder", new ListOrderUserCommand());
        commands.put("dataCountOrder", new CountOrderFormCommand());
        commands.put("countOrder", new CountOrderCommand());
        commands.put("dataForOrder", new OrderFormCommand());
        commands.put("orderUser", new OrderUserCommand());
        commands.put("dataPayment", new PaymentFormCommand());
        commands.put("PayOrder", new PayOrderCommand());
        commands.put("price", new ViewPriceCommand());
        commands.put("dataPersonAccount", new EditPersonAccountFormCommand());
        commands.put("editPersonAccount", new PersonalAccountCommand());
        commands.put("dataFotCrearteUser", new CreatUserFormCommand());
        commands.put("dataForAuthenticate", new AuthenticateFormCommand());

        commands.put("sortDate", new SortDateFromSmallerCommand());
        commands.put("sortDateForLarge", new SortDateFromLargerCommand());
        commands.put("listOrderManager", new ListOrdersManagerCommand());
        commands.put("dateEditOrder", new EditOrderFormCommand());
        commands.put("deleteOrder", new DeleteOrderCommand());
        commands.put("editOrder", new EditOrderCommand());
        commands.put("findOrderforIdOrder", new FindOrderByIdOrderManagerCommand());

        commands.put("ListUserManager", new ListUsersManagerCommand());
        commands.put("deleteUser", new DeleteUserCommand());
        commands.put("dateForEditUser", new EditUserFormCommand());
        commands.put("editUser", new EditUserCommand());
        commands.put("dateOrderManager", new OrderManagerFormCommand());
        commands.put("orderManager", new OrderManagerCommand());
        commands.put("dateForInsertUser", new CreatUserManagerFormCommand());
        commands.put("insertUser", new LoginUserCommand());
        commands.put("findUser", new FindUserByIdUserManagerCommand());
        commands.put("sortIdUserForLarger", new SortIdUserforlargerCommand());

        commands.put("ListRoute", new ListRouteManagerCommand());
        commands.put("dataEditRoute", new EditRouteFormCommand());
        commands.put("editRoute", new EditRouteCommand());
        commands.put("deleteRoute", new DeleteRouteCommand());

        commands.put("locale", new LocaleFormCommand());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.info("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
