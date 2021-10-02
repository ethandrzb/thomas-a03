/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 33
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.Random;
import java.util.Scanner;

public class Solution33
{
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();

    private static final String[] responses = {"Yes", "No", "Maybe", "Ask again later."};

    public static void main(String[] args)
    {
        Solution33 sol = new Solution33();

        // Prompt user for question
        System.out.println("What's your question?");
        System.out.print("> ");

        sc.nextLine();

        // Generate random number to determine response
        int randomNumber = sol.getRandomNumber();

        // Display chosen response
        System.out.println("\n" + sol.getResponse(randomNumber));

        // Exit
        System.exit(0);
    }

    private int getRandomNumber()
    {
        return rand.nextInt(responses.length);
    }

    public String getResponse(int index)
    {
        // Convert random number to response
        return responses[index];
    }
}
