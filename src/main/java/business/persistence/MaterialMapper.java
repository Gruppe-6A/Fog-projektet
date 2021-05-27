package business.persistence;


import business.entities.Materials;
import business.exceptions.UserException;

import java.sql.*;

public class MaterialMapper {
    private Database database;

    public MaterialMapper(Database database){
        this.database = database;
    }

    public Materials getMaterial(int material_id) throws UserException
    {
        try (Connection connection = database.connect()) {
            String sql = "select * from materials where id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, material_id);
                ResultSet resultSet = ps.executeQuery();
                resultSet.next();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int pricePerU = resultSet.getInt("price_per_unit");
                String unit = resultSet.getString("unit");

                return new Materials(id, name, pricePerU, unit);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }


}
