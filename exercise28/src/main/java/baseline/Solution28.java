/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 28
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.Scanner;

public class Solution28
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution28 sol = new Solution28();

        // Prompt user for 5 integers and compute their sum
        int sum = sol.sum5Integers();

        // Display sum
        System.out.println("The total is " + sum + ".");

        // Exit
        System.exit(0);
    }
    public int sum5Integers()
    {
        int runningTotal = 0;

        // Repeat 5 times
        for(int i = 0; i < 5; i++)
        {
            // Prompt user for integer
            System.out.print("Enter a number: ");
            // Add this integer to running total
            runningTotal += sc.nextInt();
        }

        return runningTotal;
    }
}