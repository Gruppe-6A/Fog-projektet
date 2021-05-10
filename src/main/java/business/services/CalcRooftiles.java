package business.services;

import business.entities.Result;

public class CalcRooftiles {
    private int length;
    private int width;

    public CalcRooftiles(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Result calculate(){
        int rooftile_length = length;
        int rooftile_count = (int) Math.ceil((float)width/100);

        return new Result(rooftile_count, rooftile_length);
    }
}
