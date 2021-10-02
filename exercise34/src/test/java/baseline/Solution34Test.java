/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 34 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution34Test
{
    Solution34 sol;

    @BeforeEach
    void init()
    {
        sol = new Solution34();
        sol.generateEmployeeList();
    }

    @Test
    void generateEmployeeList()
    {
        String[] expectedEmployeeList = {"John Smith"
                , "Jackie Jackson"
                , "Chris Jones"
                , "Amanda Cullen"
                , "Jeremy Goodwin"};

        String[] actualEmployeesPresent = sol.getEmployeeList();

        for(int i = 0; i < expectedEmployeeList.length; i++)
        {
            assertEquals(expectedEmployeeList[i], actualEmployeesPresent[i]);
        }
    }

    @Test
    void removeEmployee()
    {
        String nameToRemove = "Amanda Cullen";

        // Make sure name is present before removal
        boolean nameFound = false;
        for(String name : sol.getEmployeeList())
        {
            if(name.equals(nameToRemove))
            {
                nameFound = true;
                break;
            }
        }

        assertTrue(nameFound);

        sol.removeEmployee(nameToRemove);

        // Make sure name has been removed
        boolean nameExists = false;
        for(String name : sol.getEmployeeList())
        {
            if(name.equals(nameToRemove))
            {
                nameExists = true;
                break;
            }
        }

        assertFalse(nameExists);
    }
}