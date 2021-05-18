package business.entities;

public class BOMEntry {
    private String name;
    private int length;
    private int quantity;
    private String description;
    private int price;

    public BOMEntry(String name, int length, int quantity, String description, int price) {
        this.name = name;
        this.length = length;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
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
}
