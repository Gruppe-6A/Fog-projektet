package business.entities;

public class Result {
    private int length;
    private int amount;
    private int material_id;

    public Result(int length, int amount, int material_id) {
        this.length = length;
        this.amount = amount;
        this.material_id = material_id;
    }

    public int getLength() {
        return length;
    }

    public int getAmount() {
        return amount;
    }

    public int getMaterial_id() {
        return material_id;
    }
}
