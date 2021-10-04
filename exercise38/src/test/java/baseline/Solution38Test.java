/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 38 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution38Test {

    @Test
    void filterEvenNumbers()
    {
        Solution38 sol = new Solution38();

        Integer[] testArray = generateTestNumberArray();

        Integer[] actual = sol.filterEvenNumbers(testArray);

        // Make sure all numbers are even
        for(int i : actual)
        {
            assertEquals(0, i % 2);
        }
    }

    Integer[] generateTestNumberArray()
    {
        Integer[] numbers = new Integer[100];

        for(int i = -50; i < 50; i++)
        {
            numbers[i + 50] = i;
        }

        return numbers;
    }
}