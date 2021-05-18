package business.entities;

public class BOMEntry {
    private String name;
    private int length;
    private int quantity;
    private String description;

    public BOMEntry(String name, int length, int quantity, String description) {
        this.name = name;
        this.length = length;
        this.quantity = quantity;
        this.description = description;
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
}
