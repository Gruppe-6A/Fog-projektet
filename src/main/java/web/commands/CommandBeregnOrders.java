package web.commands;

import business.entities.Item;
import business.services.CalcCarport;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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
        HttpSession session = request.getSession();
        request.getParameter("");


       //orderFacade.insertIntoOrder();
       return pageToShow;
    }


}
