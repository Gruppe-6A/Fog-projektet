package business.services;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;
import business.persistence.UserMapper;

public class OrderFacade
{
    OrderMapper orderMapper;

    public OrderFacade(Database database)
    {
        orderMapper = new OrderMapper(database);
    }

    public void insertIntoOrder(Order order, int userID) throws UserException
    {
        orderMapper.insertIntoOrder(order, userID);

    }

}
