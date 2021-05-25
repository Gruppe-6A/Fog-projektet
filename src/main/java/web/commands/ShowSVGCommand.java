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
        SVG svg = new SVG(100, 0, "0 0 " + length + " " + width, length, width);
        svg.addRect(0, 35.0, 4.5, length);
        svg.addRect(0, width-39.5, 4.5, length);
        for (int x = 0; x < length/55 ; x++)
        {
            svg.addRect(0 + 55 * x, 0, length, 4.5);
        }
        svg.addRect(length-4.5, 0, width, 4.5);

        if (length<310){
            svg.addRect(0, 32.4, 9.7, 9.7);
            svg.addRect(length-10, 32.4, 9.7, 9.7);
            svg.addRect(0, width-42.4, 9.7, 9.7);
            svg.addRect(length-10, width-42.4, 9.7, 9.7);
        }
        else{
            for (int x = 0; x < Math.ceil((float)length/310); x++){
                svg.addRect(length-10 - 310 * x, 32.4, 9.7, 9.7);
            }
            for (int x = 0; x < Math.ceil((float)length/310); x++){
                svg.addRect(length-10 - 310 * x, width-42.1, 9.7, 9.7);
            }
        }


        int xOffset = length/4;
        svg.addLine(xOffset,35 ,xOffset*2,width-70);
        svg.addLine(length-xOffset,35 ,-xOffset*2,width-70);

        SVG svgMeasurements = new SVG(0, 0, "0 0 " + (length+100) + " " + (width+100), length+100, width+100);
        svgMeasurements.addDefs();
        svgMeasurements.addRect(0,0,width+100, length+100);
        svgMeasurements.addRect(100,width,1,length);
        svgMeasurements.addArrowLine(35,0, 35, width);
        svgMeasurements.addText(25, width/2, -90, width+" cm.");

        svgMeasurements.addArrowLine(85,35, 85, width-35);
        svgMeasurements.addText(75, width/2, -90, (width-70)+" cm.");

        svgMeasurements.addArrowLine(100,width+45, length+100, width+45);
        svgMeasurements.addText(length/2+100, width+60, 0, length+" cm.");

        svgMeasurements.addSvg(svg);

        request.setAttribute("svgdrawing", svgMeasurements.toString());
        //request.setAttribute("svgdrawing", svg.toString());
        return pageToShow;
    }
}
