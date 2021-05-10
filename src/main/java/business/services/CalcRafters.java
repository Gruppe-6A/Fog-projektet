package business.services;

import business.entities.Result;

public class CalcRafters {
    private int length;
    private int width;

    public CalcRafters(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Result calculate(){
        int rafter_length = width;
        int rafter_count = (int) Math.ceil((float)width/55);

        return new Result(rafter_count, rafter_length);
    }
}
