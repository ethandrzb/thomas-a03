/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 28 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution28Test
{
    @Test
    void sumIntegerArray_Case_1()
    {
        Solution28 sol = new Solution28();
        int[] testVals = {4, -3, 6, 12, 0, 921};

        assertEquals(940, sol.sumIntegerArray(testVals));
    }
}