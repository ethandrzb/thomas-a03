/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 35 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution35Test
{
    Solution35 sol;
    String[] testNames = {"name0", "name1", "name2", "name3"};

    @BeforeEach
    void init()
    {
        sol = new Solution35();
        sol.names.clear();

        sol.names.addAll(Arrays.asList(testNames));
    }

    @Test
    void generateRandomIndex()
    {
        int index = sol.generateRandomIndex();
        assertTrue(index >= 0);
        assertTrue(index < sol.names.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void selectWinner(int index)
    {
        assertEquals("name" + index, sol.selectWinner(sol.names, index));
    }
}