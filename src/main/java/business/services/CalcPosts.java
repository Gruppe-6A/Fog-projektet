package business.services;

import business.entities.Result;

public class CalcPosts {
    private int length;
    private int width;
    private int materials_id = 1;

    public CalcPosts(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Result calculate(){
        int post_length = 300;
        int post_count = 4 + (int)Math.ceil((float)(length-640)/310)*2;

        return new Result(post_length, post_count, materials_id);
    }
}
