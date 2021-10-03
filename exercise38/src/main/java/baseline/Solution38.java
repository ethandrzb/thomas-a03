/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 38
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution38
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution38 sol = new Solution38();

        Integer[] numbers;

        boolean validInput = true;
        do
        {
            // Prompt user for list of numbers
            System.out.print("Enter a list of numbers, separated by spaces: ");

            // Convert user input to array
            String[] userInput = sc.nextLine().split(" ");
            numbers = new Integer[userInput.length];
            for (int i = 0; i < userInput.length; i++)
            {
                try
                {
                    numbers[i] = Integer.parseInt(userInput[i]);

                } catch (NumberFormatException e)
                {
                    System.out.println("Input contains invalid number.");
                    validInput = false;
                }
            }
        } while (!validInput);

        // Generate copy of input array with only even numbers
        Integer[] evensOnly = sol.filterEvenNumbers(numbers);

        // Display even-only array
        System.out.println("The even numbers are " + sol.arrayToString(evensOnly) + ".");

        // Exit
        System.exit(0);
    }

    public Integer[] filterEvenNumbers(Integer[] array)
    {
        ArrayList<Integer> tmp = new ArrayList<>();

        // For each element in original array
        for(int i : array)
        {
            // Check if the element is even
            if(i % 2 == 0)
            {
                // If so, add it to the output array
                tmp.add(i);
            }
        }

        // Return output array
        return tmp.toArray(new Integer[0]);
    }

    private String arrayToString(Integer[] array)
    {
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < array.length; i++)
        {
            output.append(array[i]);

            if(i < array.length - 1)
            {
                output.append(' ');
            }
        }

        return output.toString();
    }
}
