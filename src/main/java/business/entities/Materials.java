package business.entities;

public class Materials
{

    public Materials(int id, String navn, int price_per_unit, int unit)
    {
        this.id = id;
        this.navn = navn;
        this.price_per_unit = price_per_unit;
        this.unit = unit;
    }

    private int id;
    private String navn;
    private int price_per_unit;
    private int unit;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPrice_per_unit() {
        return price_per_unit;
    }

    public void setPrice_per_unit(int price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
