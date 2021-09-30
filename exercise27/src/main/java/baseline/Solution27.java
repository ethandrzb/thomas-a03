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
        // Prompt user for first name

        // Prompt user for last name

        // Prompt user for ZIP code

        // Prompt user for employee ID

        // Display validation report

        // Exit
    }

    public String getStringFromUser(String prompt)
    {
        System.out.print(prompt + ": ");

        return sc.nextLine();
    }

    public void printInputValidationReport(String firstName, String lastName, String zipCode, String employeeID)
    {
        // Validate firstName

        // Validate lastName

        // Validate zipCode

        // Validate employeeID

        // Generate report

        // Print report
    }

    private boolean match(String input, String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public String isValidName(String name)
    {
        // Check if firstName is non-empty
        if(name.isEmpty())
        {
            return "empty";
        }

        // Check if name is at least two characters long
        return match(name, "[\\S\\s]{2,}") ? "OK" : "<2 chars";
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
