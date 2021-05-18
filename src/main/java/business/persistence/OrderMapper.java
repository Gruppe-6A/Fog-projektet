package business.persistence;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{
    private Database database;

    public OrderMapper(Database database)
    {
        this.database = database;
    }

    public int insertIntoOrder(Order order, int userID) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `fog`.`order`"+
                    "(users_id,length,height, width, price, date, status)"+
                    "VALUES (?,?,?,?,?,CURRENT_TIMESTAMP(), ?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, userID);
                ps.setInt(2, order.getLength());
                ps.setInt(3, order.getHeight());
                ps.setInt(4, order.getWidth());
                ps.setInt(5, order.getPrice());
                ps.setString(6, order.getStatus());

                ps.execute();
                ResultSet res = ps.getGeneratedKeys();
                res.next();
                return res.getInt(1);

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public int getPrice(int id) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT price FROM fog.order WHERE id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, id);
                ResultSet res = ps.executeQuery();
                res.next();
                return res.getInt(1);

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public List<Order> getOrders() throws UserException {
        List<Order> orders = new ArrayList<Order>();
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM fog.order";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet res = ps.executeQuery();
                while (res.next()){
                    int order_id = res.getInt("id");
                    int user_id = res.getInt("users_id");
                    int length = res.getInt("length");
                    int height = res.getInt("height");
                    int width = res.getInt("width");
                    int price = res.getInt("price");
                    String status = res.getString("status");
                    orders.add(new Order(order_id, user_id, length, height, width, price, status));
                }
                return orders;

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public void changeStatus(String status, int orderId) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "UPDATE `fog`.`order` SET `order`.`status` = ? where id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setString(1, status);
                ps.setInt(2, orderId);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public String getStatus(int orderId) throws UserException{
        String status = null;
        try (Connection connection = database.connect())
        {
            String sql = "SELECT status FROM `fog`.`order` where `order`.`id` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, orderId);
                ResultSet res = ps.executeQuery();
                while (res.next()){
                    status = res.getString("status");
                }
                return status;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public int getOrderId(int userId) throws UserException {
        int orderId = 0;
        try (Connection connection = database.connect())
        {
            String sql = "SELECT id FROM `fog`.`order` where `order`.`users_id` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, userId);
                ResultSet res = ps.executeQuery();
                while (res.next()){
                    orderId = res.getInt("id");
                }
                return orderId;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public void removeOrder(int orderId) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "DELETE FROM `fog`.`order` where `order`.`id` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, orderId);
                ps.execute();
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }


}
