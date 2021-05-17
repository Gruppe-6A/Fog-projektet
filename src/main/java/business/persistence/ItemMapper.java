package business.persistence;

import business.entities.Item;
import business.exceptions.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ItemMapper {
    private Database database;

    public ItemMapper(Database database){
        this.database = database;
    }

    public void insertIntoOrdered_materials(List<Item> items, int order_id) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `fog`.`ordered_materials`"+
                    "(materials_id, order_id, quantity, description, price, length)"+
                    "VALUES (?,?,?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                for (Item item: items) {
                    ps.setInt(1, item.getMaterials_id());
                    ps.setInt(2, order_id);
                    ps.setInt(3, item.getQuantity());
                    ps.setString(4, item.getDescription());
                    ps.setInt(5, item.getPrice());
                    ps.setInt(6, item.getLength());

                    ps.execute();
                }
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

    public void removeFromOrdered_materials(int order_id) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "DELETE from `fog`.`ordered_materials` where `fog`.`ordered_materials`.`order_id` = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, order_id);
                ps.execute();
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
