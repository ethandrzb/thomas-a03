/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 36 Test
 *  Copyright 2021 Ethan Thomas
 */


package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution36Test
{
    Integer[] testData = {588, 593, 645, 938, 175, 177, 640, 991};
    ArrayList<Integer> testDataList = new ArrayList<>(Arrays.asList(testData));

    @Test
    void average()
    {
        Solution36 sol = new Solution36();

        assertEquals(593.375, sol.average(testDataList), 0.00001);
    }

    @Test
    void min()
    {
        Solution36 sol = new Solution36();

        assertEquals(175, sol.min(testDataList));
    }

    @Test
    void max()
    {
        Solution36 sol = new Solution36();

        assertEquals(991, sol.max(testDataList));
    }

    @Test
    void std()
    {
        Solution36 sol = new Solution36();

        assertEquals(280.6568, sol.std(testDataList), 0.0001);
    }
}