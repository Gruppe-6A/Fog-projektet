package business.services;

import business.entities.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcRemTest {
    private CalcRem calcRem;

    @Test
    void calculate() {
        calcRem = new CalcRem(1000, 500);
        Result res = calcRem.calculate();
        assertEquals(2, res.getAmount());
        assertEquals(1000, res.getLength());
    }

}