package business.services;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;
import business.persistence.UserMapper;

import java.util.List;

public class OrderFacade
{
    OrderMapper orderMapper;

    public OrderFacade(Database database)
    {
        orderMapper = new OrderMapper(database);
    }

    public int insertIntoOrder(Order order, int userID) throws UserException
    {
      return  orderMapper.insertIntoOrder(order, userID);

    }

    public List<Order> getOrders() throws UserException
    {
        return orderMapper.getOrders();
    }

    public int getPrice(int id) throws UserException
    {
        return orderMapper.getPrice(id);
    }

    public void changeStatus(String status, int orderId) throws  UserException{
        orderMapper.changeStatus(status, orderId);
    }

    public void removeOrder(int orderId) throws UserException{
        orderMapper.removeOrder(orderId);
    }

    public String getStatus(int orderId) throws UserException {
        return orderMapper.getStatus(orderId);
    }

    public int getOrderId(int userId) throws UserException{
        return orderMapper.getOrderId(userId);
    }

}
