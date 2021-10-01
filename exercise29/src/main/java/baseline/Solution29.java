/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 29
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution29
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution29 sol = new Solution29();

        // Prompt user for rate of return
        double rate = sol.getRateFromUser();

        // Compute years needed to double investment
        double yearsNeeded = sol.getYearsNeededToDoubleInvestment(rate);

        // Display years needed to double investment
        System.out.println("It will take " + yearsNeeded + " to double your initial investment.");

        // Exit
        System.exit(0);
    }

    private double getRateFromUser()
    {
        double value;

        // Until the user enters valid input
        while(true)
        {
            // Display prompt
            System.out.print("What is the rate of return? ");

            // Attempt to parse user input as double
            try
            {
                value = sc.nextDouble();

                // If successful, check if input is 0
                if(value == 0)
                {
                    throw new IllegalArgumentException();
                }
                else
                {
                    // If not, exit loop

                    break;
                }
            }
            catch(InputMismatchException e)
            {
                // If this fails, display error message
                System.out.println("Input must be numeric.");

                sc.nextLine();
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Input cannot be 0");
            }
        }
        return value;
    }

    public double getYearsNeededToDoubleInvestment(double rate)
    {
        return 72 / rate;
    }
}
