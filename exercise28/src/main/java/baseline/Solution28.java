/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 28
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution28
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution28 sol = new Solution28();

        // Prompt user for 5 integers
        int[] numbers = sol.promptUserFor5Integers();

        // Compute sum of integers
        int sum = sol.sumIntegerArray(numbers);

        // Display sum
        System.out.println("The total is " + sum + ".");

        // Exit
        System.exit(0);
    }

    public int[] promptUserFor5Integers()
    {
        int[] numbers = new int[5];

        Arrays.fill(numbers, 0);

        // Repeat 5 times
        for(int i = 0; i < 5; i++)
        {
            // Prompt user for integer
            System.out.print("Enter a number: ");

            try
            {
                // Add this integer to running total
                numbers[i] = sc.nextInt();
            }
            catch(InputMismatchException e)
            {
                // Silently ignore bad input
                sc.nextLine();
            }
        }

        return numbers;
    }

    public int sumIntegerArray(int[] numbers)
    {
        int sum = 0;

        for(int i : numbers)
        {
            sum += i;
        }

        return sum;
    }
}