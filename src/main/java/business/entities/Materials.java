package business.entities;

public class Materials
{
    private int id;
    private String name;
    private int price_per_unit;
    private String unit;
    public Materials(int id, String name, int price_per_unit, String unit)
    {
        this.id = id;
        this.name = name;
        this.price_per_unit = price_per_unit;
        this.unit = unit;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getPrice_per_unit() {
        return price_per_unit;
    }

    public String getUnit() {
        return unit;
    }

}
