/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 39 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Solution39Test
{
    Solution39 sol;
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String POSITION = "position";
    private static final String SEPARATION_DATE = "separationDate";

    @BeforeEach
    void init()
    {
        sol = new Solution39();
        sol.generateEmployeeDatabase();
    }

    @Test
    void generateEmployeeDatabase()
    {
        ArrayList<HashMap<String, String>> actual = (ArrayList<HashMap<String, String>>) sol.getEmployeeList();

        // Check John's information
        assertEquals("John", actual.get(0).get(FIRST_NAME));
        assertEquals("Johnson", actual.get(0).get(LAST_NAME));
        assertEquals("Manager", actual.get(0).get(POSITION));
        assertEquals("2016-12-31", actual.get(0).get(SEPARATION_DATE));

        // Check Tou's information
        assertEquals("Tou", actual.get(1).get(FIRST_NAME));
        assertEquals("Xiong", actual.get(1).get(LAST_NAME));
        assertEquals("Software Engineer", actual.get(1).get(POSITION));
        assertEquals("2016-10-05", actual.get(1).get(SEPARATION_DATE));

        // Check Michaela's information
        assertEquals("Michaela", actual.get(2).get(FIRST_NAME));
        assertEquals("Michaelson", actual.get(2).get(LAST_NAME));
        assertEquals("District Manager", actual.get(2).get(POSITION));
        assertEquals("2015-12-19", actual.get(2).get(SEPARATION_DATE));

        // Check Jake's information
        assertEquals("Jake", actual.get(3).get(FIRST_NAME));
        assertEquals("Jacobson", actual.get(3).get(LAST_NAME));
        assertEquals("Programmer", actual.get(3).get(POSITION));
        assertTrue(actual.get(3).get(SEPARATION_DATE).isEmpty());

        // Check Jacquelyn's information
        assertEquals("Jacquelyn", actual.get(4).get(FIRST_NAME));
        assertEquals("Jackson", actual.get(4).get(LAST_NAME));
        assertEquals("DBA", actual.get(4).get(POSITION));
        assertTrue(actual.get(4).get(SEPARATION_DATE).isEmpty());

        // Check Sally's information
        assertEquals("Sally", actual.get(5).get(FIRST_NAME));
        assertEquals("Webber", actual.get(5).get(LAST_NAME));
        assertEquals("Web Developer", actual.get(5).get(POSITION));
        assertEquals("2015-12-18", actual.get(5).get(SEPARATION_DATE));
    }

    @Test
    void sortDatabase()
    {
        sol.sortDatabase();
        ArrayList<HashMap<String, String>> actual = (ArrayList<HashMap<String, String>>) sol.getEmployeeList();

        // Check Jacquelyn's information
        assertEquals("Jacquelyn", actual.get(0).get(FIRST_NAME));
        assertEquals("Jackson", actual.get(0).get(LAST_NAME));
        assertEquals("DBA", actual.get(0).get(POSITION));
        assertTrue(actual.get(0).get(SEPARATION_DATE).isEmpty());

        // Check Jake's information
        assertEquals("Jake", actual.get(1).get(FIRST_NAME));
        assertEquals("Jacobson", actual.get(1).get(LAST_NAME));
        assertEquals("Programmer", actual.get(1).get(POSITION));
        assertTrue(actual.get(1).get(SEPARATION_DATE).isEmpty());

        // Check John's information
        assertEquals("John", actual.get(2).get(FIRST_NAME));
        assertEquals("Johnson", actual.get(2).get(LAST_NAME));
        assertEquals("Manager", actual.get(2).get(POSITION));
        assertEquals("2016-12-31", actual.get(2).get(SEPARATION_DATE));

        // Check Michaela's information
        assertEquals("Michaela", actual.get(3).get(FIRST_NAME));
        assertEquals("Michaelson", actual.get(3).get(LAST_NAME));
        assertEquals("District Manager", actual.get(3).get(POSITION));
        assertEquals("2015-12-19", actual.get(3).get(SEPARATION_DATE));

        // Check Sally's information
        assertEquals("Sally", actual.get(4).get(FIRST_NAME));
        assertEquals("Webber", actual.get(4).get(LAST_NAME));
        assertEquals("Web Developer", actual.get(4).get(POSITION));
        assertEquals("2015-12-18", actual.get(4).get(SEPARATION_DATE));

        // Check Tou's information
        assertEquals("Tou", actual.get(5).get(FIRST_NAME));
        assertEquals("Xiong", actual.get(5).get(LAST_NAME));
        assertEquals("Software Engineer", actual.get(5).get(POSITION));
        assertEquals("2016-10-05", actual.get(5).get(SEPARATION_DATE));
    }


    @Test
    void displaySortedDatabase()
    {
        String[] expected = """
                Name                |Position          |Separation Date\r
                --------------------|------------------|---------------
                Jacquelyn Jackson   |DBA               |              \s\r
                Jake Jacobson       |Programmer        |              \s\r
                John Johnson        |Manager           |2016-12-31    \s\r
                Michaela Michaelson |District Manager  |2015-12-19    \s\r
                Sally Webber        |Web Developer     |2015-12-18    \s\r
                Tou Xiong           |Software Engineer |2016-10-05    \s\r
                """.split("\n");

        sol.sortDatabase();
        String[] actual = sol.displayDatabase().split("\n");

        for(int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }
}