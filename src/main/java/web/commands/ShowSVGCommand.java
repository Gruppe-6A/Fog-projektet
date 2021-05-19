package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.ItemMapper;
import business.persistence.OrderMapper;
import business.services.OrderFacade;
import business.services.SVG;
import javafx.scene.shape.SVGPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSVGCommand extends CommandUnprotectedPage{
    OrderFacade orderFacade = new OrderFacade(database);
    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int orderId = orderFacade.getOrderId(user.getId());
        Order order = orderFacade.getOrder(orderId);
        int length = order.getLength();
        int width = order.getWidth();
        SVG svg = new SVG(0, 0, "0 0 800 600", length, width);
        svg.addRect(0, 35.0, 4.5, length);
        svg.addRect(0, width-39.5, 4.5, length);
        /*
        for (int x = 0; x < 14; x++)
        {
            svg.addRect(100 + 50 * x, 0, 600.0, 4.5);
        }

         */
        request.setAttribute("svgdrawing", svg.toString());
        return pageToShow;
    }
}
