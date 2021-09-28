/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 24
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution24Test
{
    @Test
    void isAnagram_Case_1()
    {
        Solution24 sol = new Solution24();

        assertTrue(sol.isAnagram("note", "tone"));
    }

    @Test
    void isAnagram_Case_2()
    {
        Solution24 sol = new Solution24();

        assertFalse(sol.isAnagram("abc", "cde"));
    }

    @Test
    void isAnagram_Case_3()
    {
        Solution24 sol = new Solution24();

        assertFalse(sol.isAnagram("abcd", "abc"));
    }
}