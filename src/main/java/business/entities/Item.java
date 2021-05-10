package business.entities;

public class Item {
    int materials_id;
    int quantity;
    String description;
    int price;
    int length;

    public Item(int materials_id, int quantity, String description, int price, int length) {
        this.materials_id = materials_id;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.length = length;
    }
}
