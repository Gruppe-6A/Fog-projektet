package web.commands;

import business.entities.Item;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.ItemMapper;
import business.persistence.OrderMapper;
import business.services.CalcCarport;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ThePriceisRightCommand extends CommandProtectedPage
{
    ItemMapper itemMapper = new ItemMapper(database);
    OrderFacade orderfacade = new OrderFacade(database);

    public ThePriceisRightCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        int id = user.getId();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = 225;
        request.setAttribute("length", length);
        request.setAttribute("height", height);
        request.setAttribute("width", width);

        try {
            List<Item> items = new CalcCarport(length, width, database).itemList();
            int price=0;
            for(Item item:items){
                price+=item.getPrice();
            }
                Order order = new Order(id, length, height, width, price, "forespørgelse");
            int orderid = orderfacade.insertIntoOrder(order, id);
            request.setAttribute("price", orderfacade.getPrice(orderid));
            itemMapper.insertIntoOrdered_materials(items, orderid);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return pageToShow;
    }
    public String getRole()
    {
        return role;
    }
}
