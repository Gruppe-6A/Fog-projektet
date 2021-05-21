package business.services;

import business.entities.Result;

public class CalcRooftiles {
    private int length;
    private int width;
    private int materials_id = 3;

    public CalcRooftiles(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Result calculate(){
        int rooftile_length = 600;
        int rooftile_widthcount = (int) Math.ceil((float)width/100);
        int rooftile_lengthcount = (int) Math.ceil((float)length/600);
        int rooftile_count = rooftile_lengthcount * rooftile_widthcount;
        return new Result(rooftile_length, rooftile_count, materials_id);
    }
}
