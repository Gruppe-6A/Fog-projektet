package business.services;

import business.entities.Result;

public class CalcRem {
    private int length;
    private int width;
    private int materials_id = 2;

    public CalcRem(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Result calculate(){
        return new Result(2, length, materials_id);
    }
}
