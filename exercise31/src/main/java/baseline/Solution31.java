/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 31
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution31
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution31 sol = new Solution31();

        // Get resting pulse from user
        int restingHeartRate = sol.getIntFromUser("Resting Pulse");

        // Get age from user
        int age = sol.getIntFromUser("Age");

        // Generate target heart rate table
        String targetHeartRateTable = sol.generateTargetHeartRateTable(restingHeartRate, age);

        // Display table
        System.out.print(targetHeartRateTable);

        // Exit
        System.exit(0);
    }
    private int getIntFromUser(String prompt)
    {
        int value;

        while(true)
        {
            System.out.print(prompt + ": ");

            try
            {
                value = sc.nextInt();
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Input must be an integer.");

                sc.nextLine();
            }
        }
        return value;
    }

    public String generateTargetHeartRateTable(int restingHeartRate, int age)
    {
        StringBuilder table = new StringBuilder();

        // Generate table header
        table.append(String.format("%13s| %7s%n", "Intensity", "Rate"));
        table.append("-------------|--------\n");

        // For each intensity i from 55% to 95%
        for(int i = 55; i <= 95; i += 5)
        {
            // Compute the target heart rate
            // Append intensity and target heart rate to table
            table.append(generateTargetHeartRateTableRow(i, getTargetHeartRate(restingHeartRate, age, i)));
        }

        // Return table
        return table.toString();
    }

    private String generateTargetHeartRateTableRow(int intensity, int targetHeartRate)
    {
        return String.format("%13s| %7s%n", intensity + "%", targetHeartRate + " BPM");
    }

    public int getTargetHeartRate(int restingHeartRate, int age, int intensity)
    {
        // Compute target heart rate for given age, resting heart rate, and intensity
        double intensityFactor = intensity / 100.0;

        return (int)Math.round((((220 - age) - restingHeartRate) * intensityFactor) + restingHeartRate);
    }
}
