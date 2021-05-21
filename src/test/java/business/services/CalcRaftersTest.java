package business.services;

import business.entities.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcRaftersTest {
    private CalcRafters calcRafters;
    @Test
    void calculate() {
        calcRafters = new CalcRafters(1000, 500);
        Result result = calcRafters.calculate();
        assertEquals(500, result.getLength());
        assertEquals(19, result.getAmount());
    }

    @Test
    void minimumrafters() {
        calcRafters = new CalcRafters(54, 500);
        Result result = calcRafters.calculate();
        assertEquals(2, result.getAmount());
    }
}