/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 31 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution31Test {

    @Test
    void generateTargetHeartRateTable()
    {
        Solution31 sol = new Solution31();

        String expected = """
            Intensity    |    Rate\r
            -------------|--------
            55%          | 138 BPM\r
            60%          | 145 BPM\r
            65%          | 151 BPM\r
            70%          | 158 BPM\r
            75%          | 165 BPM\r
            80%          | 171 BPM\r
            85%          | 178 BPM\r
            90%          | 185 BPM\r
            95%          | 191 BPM\r
                          """;
        assertEquals(expected, sol.generateTargetHeartRateTable(65, 22));
    }

    @Test
    void getTargetHeartRate_Case_1()
    {
        Solution31 sol = new Solution31();

        assertEquals(145, sol.getTargetHeartRate(65, 22, 60));
    }

    @Test
    void getTargetHeartRate_Case_2()
    {
        Solution31 sol = new Solution31();

        assertEquals(180, sol.getTargetHeartRate(68, 20, 85));
    }
}