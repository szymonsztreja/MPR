package pl.edu.pjatk.testy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    @Test
    public void baseOf2RaisedTo3Equals8(){
        int expected = 8;
        int result = Calculator.power(2,3);
        assertEquals(expected, result);
    }

    @Test
    public void baseOf4RaisedTo4Equals256(){
        int expected = 256;
        int result = Calculator.power(4,4);
        assertEquals(expected, result);
    }
    @Test
    public void negativeBaseRaisedToEvenExponentEqualsPositive(){
        int result = Calculator.power(-2,4);
        assertTrue( result > 0);
    }

    @Test
    public void negativeBaseRaisedToOddExponentEqualsNegative(){
//        int expected = -8;
        int result = Calculator.power(-2,3);
//        assertEquals(expected, result);
        assertTrue( result < 0);
    }

    @Test
    public void number4DividedBy2Equals2(){
        boolean result = Calculator.dividable(4,2);
        assertTrue(result);
    }


}
