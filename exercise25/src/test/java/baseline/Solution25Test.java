/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 25
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution25Test
{
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

    @Test
    void passwordValidator_case_4()
    {
        Solution25 sol = new Solution25();

        assertEquals(3,sol.passwordValidator("1337h@xor!"));
    }

    @Test
    void passwordValidator_unknown_strength_case_1()
    {
        Solution25 sol = new Solution25();

        // Numbers and letters, but less than 8 characters

        assertEquals(-1,sol.passwordValidator("ab23"));
    }

    @Test
    void passwordValidator_unknown_strength_case_2()
    {
        Solution25 sol = new Solution25();

        // More than 8 characters, but only letters

        assertEquals(-1,sol.passwordValidator("abcdefgh"));
    }

    @Test
    void passwordValidator_unknown_strength_case_3()
    {
        Solution25 sol = new Solution25();

        // More than 8 characters, but only special characters

        assertEquals(-1,sol.passwordValidator("$#%] ^\\%@!"));
    }

    @Test
    void generatePasswordReport_unknown_strength_case_1()
    {
        Solution25 sol = new Solution25();

        // Numbers and letters, but less than 8 characters

        assertEquals("The password 'ab23' is of unknown strength.",sol.generatePasswordReport("ab23"));
    }

    @Test
    void generatePasswordReport_unknown_strength_case_2()
    {
        Solution25 sol = new Solution25();

        // More than 8 characters, but only letters

        assertEquals("The password 'abcdefgh' is of unknown strength.",sol.generatePasswordReport("abcdefgh"));
    }

    @Test
    void generatePasswordReport_unknown_strength_case_3()
    {
        Solution25 sol = new Solution25();

        // More than 8 characters, but only special characters

        assertEquals("The password '$#%] ^\\%@!' is of unknown strength.",sol.generatePasswordReport("$#%] ^\\%@!"));

    }
}