package business.persistence;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

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
                    "(users_id,length,height, width)"+
                    "VALUES (?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, userID);
                ps.setInt(2, order.getLength());
                ps.setInt(3, order.getHeight());
                ps.setInt(4, order.getWidth());
               // System.out.println(id);


                ps.execute();
                ResultSet res = ps.getResultSet();
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

}
