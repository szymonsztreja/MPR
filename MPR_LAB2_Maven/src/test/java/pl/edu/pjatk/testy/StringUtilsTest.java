package pl.edu.pjatk.testy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void alaToUpperCase(){
        String expected = "ALA MA KOTA";
        String ALA = StringUtils.toUpperCaseTest("ala ma kota");
        assertEquals(expected, ALA);
    }

    @Test
    public void alaToUpperCaseWithCapitalLetter(){
        String expected = "ALA MA !!!";
        String ALA = StringUtils.toUpperCaseTest("ala ma !!!");
        assertEquals(expected, ALA);
    }

    @Test
    public void reverseStringTest(){
        String expected = "ćawomargorp eibul";
        String reversed = StringUtils.reverse("lubie programować");
        assertEquals(expected, reversed);
    }

    @Test
    public void multipliedStringTest(){
        String expected = "test test test";
        String multiplied = StringUtils.multiplyString("test", 3);
        assertEquals(expected, multiplied);
    }
//
//    @Test
//    public void checkHowManyTimesMultiplied(){
//        String expected = "test test test";
//        String multiplied = StringUtils.multiplyString("test", 3);
//        assertEquals(expected, multiplied);
//    }

//    @Test
//    public void remove4SmallChars(){
//        String expected = "J K";
//        String smallCharLess = StringUtils.removeSmallChars("Jan Kowalski");
//        assertEquals(expected, multiplied);
//    }

}

