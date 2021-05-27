package business.services;

import business.entities.Item;
import business.entities.Result;
import business.exceptions.UserException;
import business.persistence.Database;

import java.util.ArrayList;
import java.util.List;

public class CalcCarport {
    private int length;
    private int width;
    private List<Item> list;
    private Database database;

    public CalcCarport(int length, int width, Database database) {
        this.length = length;
        this.width = width;
        list = new ArrayList<Item>();
        this.database = database;
    }

    public List<Item> itemList() throws UserException {
        Result posts = new CalcPosts(length, width).calculate();
        list.add(new Item(posts.getMaterial_id(), posts.getAmount(), "Stolper nedgraves 90 cm. i jord", new PriceCalculator(database).calcPrice(length, posts.getAmount(), posts.getMaterial_id()), posts.getLength()));

        Result rem = new CalcRem(length, width).calculate();
        list.add(new Item(rem.getMaterial_id(), rem.getAmount(), "Remme i sider, sadles ned i stolper", new PriceCalculator(database).calcPrice(length, rem.getAmount(), rem.getMaterial_id()), rem.getLength()));

        Result rafters = new CalcRafters(length, width).calculate();
        list.add(new Item(rafters.getMaterial_id(), rafters.getAmount(), "Spær, monteres på rem", new PriceCalculator(database).calcPrice(length, rafters.getAmount(), rafters.getMaterial_id()), rafters.getLength()));

        Result rooftile = new CalcRooftiles(length, width).calculate();
        list.add(new Item(rooftile.getMaterial_id(), rooftile.getAmount(), "tagplader monteres på spær", new PriceCalculator(database).calcPrice(length, rooftile.getAmount(), rooftile.getMaterial_id()), rooftile.getLength()));
        System.out.println(rooftile.getAmount());
        return list;
    }

}