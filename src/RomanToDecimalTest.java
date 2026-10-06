/**
 * Tests the RomanToDeciaml class to check that it functions as intended
 * @author 27gunscha
 * @version 9/5/26
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToDecimalTest {

    @Test
    public void testRomanToDecimalTest() {

        //Valid
        assertEquals(RomanToDecimal.romanToDecimal("cclix"), 259);
        assertEquals(RomanToDecimal.romanToDecimal("IV"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("MCMLXXXIII"), 1983);
        assertEquals(RomanToDecimal.romanToDecimal("MmXi"), 2011);
        assertEquals(RomanToDecimal.romanToDecimal("dxxi"), 521);
        assertEquals(RomanToDecimal.romanToDecimal("MCMxciv"), 1994);
        assertEquals(RomanToDecimal.romanToDecimal("CIX"), 109);
        assertEquals(RomanToDecimal.romanToDecimal("MXc"), 1090);
        assertEquals(RomanToDecimal.romanToDecimal("XIV"), 14);
        assertEquals(RomanToDecimal.romanToDecimal("xl"), 40);

        //Logically incorrect
        assertEquals(RomanToDecimal.romanToDecimal("IIIV"), 6);
        assertEquals(RomanToDecimal.romanToDecimal("XM"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("Ic"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("IXix"), 20);


        //Invalid cases
        assertEquals(RomanToDecimal.romanToDecimal("MANAMAMA"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("!**@ABC"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("HELLO MR. COCHRAN"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("BYE MR. COCHRAN"), -1);

        //assertNotEquals
        assertNotEquals(RomanToDecimal.romanToDecimal("ixixix"), 27);
        assertNotEquals(RomanToDecimal.romanToDecimal("MMMXCLi"), 19);
    }
}