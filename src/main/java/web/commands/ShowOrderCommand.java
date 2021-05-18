package web.commands;

import business.entities.Item;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.ItemMapper;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowOrderCommand extends CommandProtectedPage{
    OrderFacade orderFacade = new OrderFacade(database);
    ItemMapper itemMapper = new ItemMapper(database);

    public ShowOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int orderId = orderFacade.getOrderId(user.getId());
        if (request.getParameter("status") != null && request.getParameter("status").equals("godkendt")){
            orderFacade.changeStatus("betalt", orderId);
        }

        String status = orderFacade.getStatus(orderId);
        if (status.equals("godkendt")){
            request.setAttribute("status", "godkendt");
            request.setAttribute("order", orderFacade.getOrder(orderId));
        }
        else if (status.equals("betalt")){
            request.setAttribute("status", "betalt");
            request.setAttribute("BOMList", itemMapper.getBOMEntries(orderId));
            request.setAttribute("samletpris", orderFacade.getPrice(orderId));
        }
        else if (status.equals("forespørgelse")){
            request.setAttribute("status", "forespørgelse");
        }



        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
