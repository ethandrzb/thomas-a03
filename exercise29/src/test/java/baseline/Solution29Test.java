/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 29 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution29Test {

    @Test
    void getYearsNeededToDoubleInvestment()
    {
        Solution29 sol = new Solution29();

        assertEquals(18.0, sol.getYearsNeededToDoubleInvestment(4), 0.00001);
    }
}