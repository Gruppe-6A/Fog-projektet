package business.services;

import business.entities.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcRooftilesTest {
    private CalcRooftiles calcRooftiles;
    @Test
    void calculate() {
        calcRooftiles = new CalcRooftiles(1000, 500);
        Result res = calcRooftiles.calculate();
        assertEquals(10, res.getAmount());
        assertEquals(600, res.getLength());
    }
    @Test
    void minimumrooftiles() {
        calcRooftiles = new CalcRooftiles(500, 90);
        Result res = calcRooftiles.calculate();
        assertEquals(1, res.getAmount());
        assertEquals(600, res.getLength());
    }
}