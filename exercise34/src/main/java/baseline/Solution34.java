/*
 * / UCF COP3330 Fall 2021 Assignment 3 Solution 34
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution34
{
    private static final Scanner sc = new Scanner(System.in);
    private static ArrayList<String> employeeList = new ArrayList<>();

    public static void main(String[] args)
    {
        Solution34 sol = new Solution34();
        sol.generateEmployeeList();

        // Display employee list
        sol.displayEmployeeList();
        System.out.println();

        // Prompt user for employee to remove
        System.out.print("Enter an employee name to remove: ");
        String removeName = sc.nextLine();

        // Attempt to remove employee
        sol.removeEmployee(removeName);

        // Display employee list
        System.out.println();
        sol.displayEmployeeList();

        // Exit
        System.exit(0);
    }

    public void generateEmployeeList()
    {
        employeeList.add("John Smith");
        employeeList.add("Jackie Johnson");
        employeeList.add("Chris Jones");
        employeeList.add("Amanda Cullen");
        employeeList.add("Jeremy Goodwin");
    }

    private void displayEmployeeList()
    {
        // Display number of employees stored
        System.out.println("There are " + employeeList.size() + " employees");

        // Display all employees stored
        for(String name : employeeList)
        {
            System.out.println(name);
        }
    }

    public void removeEmployee(String employeeName)
    {
        employeeList.remove(employeeName);
    }
}
