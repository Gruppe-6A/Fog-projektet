package business.entities;

public class Result {
    private int length;
    private int amount;

    public Result(int length, int amount) {
        this.length = length;
        this.amount = amount;
    }

    public int getLength() {
        return length;
    }

    public int getAmount() {
        return amount;
    }
}
