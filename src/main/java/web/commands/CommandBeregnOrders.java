package web.commands;

import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandBeregnOrders extends CommandProtectedPage
{
    public String role;
    public String pageToShow;
    private OrderFacade orderFacade;

    public CommandBeregnOrders(String pageToShow, String role)
    {
        super(role, pageToShow);
        orderFacade = new OrderFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {


       // orderFacade.insertIntoOrder();
        return pageToShow;
    }


}
