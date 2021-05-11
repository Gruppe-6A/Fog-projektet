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

    public int getMaterials_id() {
        return materials_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getLength() {
        return length;
    }
}
