package business.entities;

public class Order {

    private int order_id;
    private int users_id;
    private int length;
    private int height;
    private int width;
    private int price;
    private String status;

    public Order( int users_id, int length, int height, int width, int price, String status) {

        this.users_id = users_id;
        this.length = length;
        this.height = height;
        this.width = width;
        this.price = price;
        this.status = status;
    }

    public Order( int order_id, int users_id, int length, int height, int width, int price, String status) {
        this.order_id = order_id;
        this.users_id = users_id;
        this.length = length;
        this.height = height;
        this.width = width;
        this.price = price;
        this.status = status;
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

    public int getOrder_id() {
        return order_id;
    }

    public String getStatus() {
        return status;
    }
}
