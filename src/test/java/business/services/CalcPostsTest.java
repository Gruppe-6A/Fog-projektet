package business.services;

import business.entities.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcPostsTest {
    private CalcPosts calcPosts;


    @Test
    void calculate() {
        calcPosts = new CalcPosts(1000, 500);
       Result res = calcPosts.calculate();
        assertEquals(300, res.getLength());
        assertEquals(8, res.getAmount());
    }

    @Test
    void minimumposts() {
        calcPosts = new CalcPosts(309, 150);
        Result res = calcPosts.calculate();
        assertEquals(4, res.getAmount());
    }
}