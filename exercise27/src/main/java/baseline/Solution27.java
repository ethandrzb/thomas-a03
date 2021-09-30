/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 27
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution27
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution27 sol = new Solution27();

        // Prompt user for first name
        String firstName = sol.getStringFromUser("Enter the first name");

        // Prompt user for last name
        String lastName = sol.getStringFromUser("Enter the last name");

        // Prompt user for ZIP code
        String zipCode = sol.getStringFromUser("Enter the ZIP code");

        // Prompt user for employee ID
        String employeeID = sol.getStringFromUser("Enter the employee ID");

        // Display validation report
        sol.validateInput(firstName, lastName, zipCode, employeeID);

        // Exit
        System.exit(0);
    }

    public String getStringFromUser(String prompt)
    {
        System.out.print(prompt + ": ");

        return sc.nextLine();
    }

    public void validateInput(String firstName, String lastName, String zipCode, String employeeID)
    {
        String report = "";
        boolean errorEncountered = false;

        // Validate firstName
        if(isValidName(firstName) == -1)
        {
            report += "The first name must be filled in.\n";

            errorEncountered = true;
        }
        else if(isValidName(firstName) == -2)
        {
            report += "The first name must be at least 2 characters long.\n";

            errorEncountered = true;
        }

        // Validate lastName
        if(isValidName(lastName) == -1)
        {
            report += "The last name must be filled in.\n";

            errorEncountered = true;
        }
        else if(isValidName(lastName) == -2)
        {
            report += "The last name must be at least 2 characters long.\n";

            errorEncountered = true;
        }

        // Validate zipCode
        if(!isValidZIPCode(zipCode))
        {
            report += "The zipcode must be a 5 digit number.\n";
            errorEncountered = true;
        }

        // Validate employeeID
        if(!isValidEmployeeID(employeeID))
        {
            report += "The employee ID must be in the format of AA-1234\n";
        }

        if(!errorEncountered)
        {
            report = "There were no errors found.\n";
        }

        // Print report
        System.out.print(report);
    }

    private boolean match(String input, String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public int isValidName(String name)
    {
        // Check if firstName is non-empty
        if(name.isEmpty())
        {
            return -1;
        }

        // Check if name is at least two characters long
        return match(name, "[\\S\\s]{2,}") ? 0 : -2;
    }

    public boolean isValidZIPCode(String zipCode)
    {
        // Check if zipCode is 5-digit number

        return match(zipCode, "\\d{5}");
    }

    public boolean isValidEmployeeID(String employeeID)
    {
        // Check if employeeID follows the specified format

        return match(employeeID, "[a-zA-Z]{2}-\\d{4}");
    }
}
