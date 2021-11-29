package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.controller.Data.*;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandManager  {

    private static final Logger LOG = Logger.getLogger(CommandManager.class);
    private static Map<String, Command> commands = new HashMap<String, Command>();

    static {

        commands.put("creatUser", new SignUpUserCommand());
        commands.put("authenticate", new AuthenticateCommand());
        commands.put("insertRoute", new RouteManagerCommand());
        commands.put("listOrder", new ListOrderUserCommand());
        commands.put("dataCountOrder" , new DataForCountOrderCommand());
        commands.put("countOrder" , new CountOrderCommand());
        commands.put("dataForOrder" , new DataforOrderCommand());
        commands.put("orderUser" , new OrderUserCommand());
        commands.put("dataPayment" , new DataPaymentCommand());
        commands.put("PayOrder" , new PayOrderCommand());
        commands.put("price" , new ViewPriceCommand());
        commands.put("dataPersonAccount" , new DataEditPersonAccountCommand());
        commands.put("editPersonAccount" , new PersonalAccountCommand());
        commands.put("dataFotCrearteUser" , new DataForCreatUserCommand());
        commands.put("dataForAuthenticate" , new DataForAuthenticateCommand());

        commands.put("sortDate" , new SortDateFromSmallerCommand());
        commands.put("sortDateForLarge" , new SortDateFromLargerCommand());
        commands.put("listOrderManager" , new ListOrdersManagerCommand());
        commands.put("dateEditOrder" , new DataForEditOrderCommand());
        commands.put("deleteOrder", new DeleteOrderCommand());
        commands.put("editOrder", new EditOrderCommand());
        commands.put("findOrderforIdOrder", new FindOrderByIdOrderManagerCommand());

        commands.put("ListUserManager", new ListUsersManagerCommand());
        commands.put("deleteUser", new DeleteUserCommand());
        commands.put("dateForEditUser", new DataForEditUserCommand());
        commands.put("editUser", new EditUserCommand());
        commands.put("dateOrderManager", new DataforOrderManagerCommand());
        commands.put("orderManager", new OrderManagerCommand());
        commands.put("dateForInsertUser", new DataForCreatUserManagerCommand());
        commands.put("insertUser", new LoginUserCommand());
        commands.put("findUser", new FindUserByIdUserManagerCommand());
        commands.put("sortIdUserForLarger" , new SortIdUserforlargerCommand());

        commands.put("ListRoute", new ListRouteManagerCommand());
        commands.put("dataEditRoute", new DataForEditRouteCommand());
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
