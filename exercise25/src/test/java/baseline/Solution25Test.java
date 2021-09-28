/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 25
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution25Test
{
//    private static final String[] testPasswords = {"12345", "abcdef", "abc123xyz", "1337h@xor!"};
    @Test
    void passwordValidator_case_1()
    {
        Solution25 sol = new Solution25();

        assertEquals(0,sol.passwordValidator("12345"));
    }

    @Test
    void passwordValidator_case_2()
    {
        Solution25 sol = new Solution25();

        assertEquals(1,sol.passwordValidator("abcdef"));
    }

    @Test
    void passwordValidator_case_3()
    {
        Solution25 sol = new Solution25();

        assertEquals(2,sol.passwordValidator("abc123xyz"));
    }
//
//    @Test
//    void passwordValidator_case_4()
//    {
//        Solution25 sol = new Solution25();
//
//        assertEquals(3,sol.passwordValidator("1337h@xor!"));
//    }
}