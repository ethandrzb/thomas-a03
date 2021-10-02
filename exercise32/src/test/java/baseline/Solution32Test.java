/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 32 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution32Test
{
    @ParameterizedTest
    @CsvSource(textBlock = """
            1, 10
            2, 100
            3, 1000
            """)
    void generateTargetNumber(int difficultyLevel, int maxValue)
    {
        Solution32 sol = new Solution32();

        int actual = sol.generateTargetNumber(difficultyLevel);

        assertTrue(actual >= 1);
        assertTrue(actual <= maxValue);
    }
}