package business.services;

import business.entities.Item;
import business.entities.Result;
import business.exceptions.UserException;

import java.util.ArrayList;
import java.util.List;

public class CalcCarport {
    private int length;
    private int width;
    private List<Item> list;

    public CalcCarport(int length, int width) {
        this.length = length;
        this.width = width;
        list = new ArrayList<Item>();
    }

    public List<Item> itemList() throws UserException {
        Result posts = new CalcPosts(length, width).calculate();
        list.add(new Item(posts.getMaterial_id(), posts.getAmount(), "Stolper nedgraves 90 cm. i jord", new PriceCalculator(length, posts.getAmount(), posts.getMaterial_id()).calcPrice(), posts.getLength()));

        Result rem = new CalcRem(length, width).calculate();
        list.add(new Item(rem.getMaterial_id(), rem.getAmount(), "Remme i sider, sadles ned i stolper", new PriceCalculator(length, rem.getAmount(), rem.getMaterial_id()).calcPrice(), rem.getLength()));

        Result rafters = new CalcRafters(length, width).calculate();
        list.add(new Item(rafters.getMaterial_id(), rafters.getAmount(), "Spær, monteres på rem", new PriceCalculator(length, rafters.getAmount(), rafters.getMaterial_id()).calcPrice(), rafters.getLength()));

        Result rooftile = new CalcRooftiles(length, width).calculate();
        list.add(new Item(rooftile.getMaterial_id(), rooftile.getAmount(), "tagplader monteres på spær", new PriceCalculator(length, rooftile.getAmount(), rooftile.getMaterial_id()).calcPrice(), rooftile.getLength()));

        return list;
    }

}