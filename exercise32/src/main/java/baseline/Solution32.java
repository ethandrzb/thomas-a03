/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 32
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.Random;
import java.util.Scanner;

public class Solution32
{
    private static final Scanner sc = new Scanner(System.in);

    private int numGuesses;

    public static void main(String[] args)
    {
        Solution32 sol = new Solution32();

        // Display title
        System.out.println("Let's play Guess the Number!");

        // Run game
        sol.gameRunner();

        // Exit
        System.exit(0);
    }

    private int getIntFromUser(String prompt, boolean increaseNumGuessesOnInvalidInput)
    {
        int value;

        while(true)
        {
            System.out.print(prompt);

            try
            {
                value = Integer.parseInt(sc.nextLine());
                break;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Input must be an integer.");

                // Count invalid input as wrong guess
                if(increaseNumGuessesOnInvalidInput)
                {
                    numGuesses++;
                }
            }
        }
        return value;
    }

    private boolean continueGame()
    {
        String userInput;

        while(true)
        {
            // Ask user if they want to play again
            System.out.print("Do you wish to play again (Y/N)? ");

            userInput = sc.nextLine();

            if(userInput.equals("Y") || userInput.equals("y"))
            {
                return true;
            }
            else if(userInput.equals("N") || userInput.equals("n"))
            {
                return false;
            }
            else
            {
                System.out.println("Invalid choice entered. Enter 'Y' for yes or 'N' for no.");
            }
        }
    }

    private void gameRunner()
    {
        do
        {
            // Run game
            guessTheNumber();

        }while(continueGame());
    }

    private void guessTheNumber()
    {
        numGuesses = 0;

        // Prompt user for difficulty level
        int difficultyLevel = getIntFromUser("Enter the difficulty level (1, 2, or 3): ", false);

        // Get target number for user to guess
        int target = generateTargetNumber(difficultyLevel, System.currentTimeMillis());

        // Prompt user for first guess
        int guess = getIntFromUser("I have my number. What's your guess? ", true);
        numGuesses++;

        // while user's guess is incorrect
        while(guess != target)
        {
            // Display whether the user's guess was too high or too low
            if(guess < target)
            {
                System.out.print("Too low. ");
            }
            else
            {
                System.out.print("Too high. ");
            }

            // Prompt user for their guess
            guess = getIntFromUser("Guess again: ", true);
            // Increment number of guesses made so far
            numGuesses++;
        }

        // Display game results
        System.out.println("You got it in " + numGuesses + " guesses!");
    }

    public int generateTargetNumber(int difficultyLevel, long seed)
    {
        Random rand = new Random(seed);

        // Get maximum value for target number
        int maxTargetValue = convertDifficultyLevelToTargetRange(difficultyLevel);

        // Randomly generate target number within range set by difficulty
        return rand.nextInt(maxTargetValue) + 1;
    }

    private int convertDifficultyLevelToTargetRange(int difficultyLevel)
    {
        // Convert difficulty level to target value range
        return switch(difficultyLevel)
                {
                    case 1 -> 10;
                    case 2 -> 100;
                    case 3 -> 1000;
                    default -> 1;
                };
    }
}
