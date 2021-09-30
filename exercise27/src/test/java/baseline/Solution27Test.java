/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 27 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution27Test
{

    @Test
    void isValidName()
    {
        Solution27 sol = new Solution27();

        assertEquals("empty", sol.isValidName(""));

        assertEquals("<2 chars", sol.isValidName(" "));
        assertEquals("<2 chars", sol.isValidName("w"));

        assertEquals("OK", sol.isValidName("name"));
        assertEquals("OK", sol.isValidName("    "));
    }

    @Test
    void isValidZIPCode()
    {
        Solution27 sol = new Solution27();

        assertTrue(sol.isValidZIPCode("18567"));
        assertTrue(sol.isValidZIPCode("12345"));

        assertFalse(sol.isValidZIPCode("asdfg"));
        assertFalse(sol.isValidZIPCode("1234"));
        assertFalse(sol.isValidZIPCode("123456"));
    }

    @Test
    void isValidEmployeeID()
    {
        Solution27 sol = new Solution27();

        assertTrue(sol.isValidEmployeeID("AA-1234"));
        assertTrue(sol.isValidEmployeeID("RE-5641"));

        assertFalse(sol.isValidEmployeeID("AA1234"));
        assertFalse(sol.isValidEmployeeID("AA-123"));
        assertFalse(sol.isValidEmployeeID("AA-12345"));
        assertFalse(sol.isValidEmployeeID(""));
        assertFalse(sol.isValidEmployeeID("1234-AA"));
    }
}