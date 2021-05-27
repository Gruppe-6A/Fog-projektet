package business.services;

import business.entities.Materials;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.MaterialMapper;


public class PriceCalculator {
    private MaterialMapper materialMapper;
    private Database database;
    public PriceCalculator(Database database) {
        this.database = database;
        materialMapper = new MaterialMapper(database);
    }

    public int calcPrice(int length, int amount, int material_id) throws UserException {
        int price = 0;
        try {
            Materials material = materialMapper.getMaterial(material_id);
                String unit = material.getUnit();
                int price_per_unit = material.getPrice_per_unit();
                if (unit.equals("meter")) {
                    price = (int) (((float)length / 100.0) * (float)price_per_unit * (float)amount);
                }
                else if (unit.equals("stk"))
                {
                    price = price_per_unit * amount;
                }
                return price;

        } catch (UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }


}
