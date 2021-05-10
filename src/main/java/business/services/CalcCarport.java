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
        int materials_id = 1;

        list.add(new Item(materials_id, posts.getAmount(), "Stolper nedgraves 90 cm. i jord", new PriceCalculator(length, posts.getAmount(), materials_id).calcPrice(), posts.getLength()));

        return list;
    }

}