package business.persistence;

import business.entities.BOMEntry;
import business.entities.Item;
import business.entities.Result;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
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

    public List<BOMEntry> getBOMEntries(int orderId) throws UserException {
        List<BOMEntry> items = new ArrayList<>();
        try (Connection connection = database.connect())
        {
            String sql = "SELECT `m`.`name`, `om`.`length`, `om`.`quantity`, `om`.`description` from `materials` m join `ordered_materials` om on `om`.`materials_id` = `m`.`id` where `om`.`order_id` = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, orderId);
                ResultSet res = ps.executeQuery();

                while(res.next()){
                    items.add(new BOMEntry(res.getString("name"), res.getInt("length"), res.getInt("quantity"), res.getString("description")));
                }
                return items;
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
