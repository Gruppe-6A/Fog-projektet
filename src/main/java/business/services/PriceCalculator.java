package business.services;

import business.exceptions.UserException;
import business.persistence.Database;
import web.commands.Command;
import java.sql.*;

public class PriceCalculator {
    int length;
    int amount;
    int material_id;
    private Database database;
    public PriceCalculator(int length, int amount, int material_id, Database database) {
        this.length = length;
        this.amount = amount;
        this.material_id = material_id;
        this.database = database;
    }

    public int calcPrice() throws UserException {
        int price = 0;
        try (Connection connection = database.connect()) {
            String sql = "select unit, price_per_unit from materials where id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, material_id);
                ResultSet resultSet = ps.executeQuery();
                resultSet.next();
                String unit = resultSet.getString(1);
                int price_per_unit = resultSet.getInt(2);
                if (unit.equals("meter")) {
                    price = (int) (((float) length / 100.0) * (float)price_per_unit * (float)amount);
                }
                else if (unit.equals("stk"))
                {
                    price = price_per_unit * amount;
                }

                return price;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }


}
