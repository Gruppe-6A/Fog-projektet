package business.entities;

public class Order {
    private int id;
    private int users_id;
    private int length;
    private int height;
    private int width;
    private int price;

    public Order(int id, int users_id, int length, int height, int width, int price) {
        this.id = id;
        this.users_id = users_id;
        this.length = length;
        this.height = height;
        this.width = width;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getPrice() {
        return price;
    }
}
