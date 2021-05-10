package business.services;

import business.entities.Result;

public class CalcPosts {
    private int length;
    private int width;

    public CalcPosts(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Result calculate(){
        int post_length = 300;
        int post_count = (int) Math.ceil((float)length/310)*2;

        return new Result(post_count, post_length);
    }
}
