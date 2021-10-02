/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 33 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution33Test {

    @ParameterizedTest
    @CsvSource(textBlock = """
            0, Yes
            1, No
            2, Maybe
            3, Ask again later.
            """)
    void getResponse(int index, String expectedResponse)
    {
        Solution33 sol = new Solution33();

        assertEquals(expectedResponse, sol.getResponse(index));
    }
}