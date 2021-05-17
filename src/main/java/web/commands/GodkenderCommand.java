package web.commands;

import business.entities.Item;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.ItemMapper;
import business.services.CalcCarport;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GodkenderCommand extends CommandProtectedPage
{
    ItemMapper itemMapper = new ItemMapper(database);
    OrderFacade orderfacade = new OrderFacade(database);

    public GodkenderCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        if (request.getParameter("orderid") != null){
            if (request.getParameter("godkendt").equals("true")){
                orderfacade.changeStatus("godkendt", Integer.parseInt(request.getParameter("orderid")));
            }
            else if (request.getParameter("godkendt").equals("false")){
                itemMapper.removeFromOrdered_materials(Integer.parseInt(request.getParameter("orderid")));
                orderfacade.removeOrder(Integer.parseInt(request.getParameter("orderid")));
            }
        }

        List<Order> orderList = orderfacade.getOrders();
        request.setAttribute("orderList", orderList);



        return pageToShow;
    }
    public String getRole()
    {
        return role;
    }
}
