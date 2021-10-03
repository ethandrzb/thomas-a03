/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 36
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution36
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution36 sol = new Solution36();

        // Get data from user
        ArrayList<Integer> data = sol.getDataFromUser();

        // Display entered data
        sol.displayData(data);

        // Compute desired statistics on data
        double average = sol.average(data);
        int min = sol.min(data);
        int max = sol.max(data);
        double std = sol.std(data);

        // Display statistics
        sol.displayStatistics(average, min, max, std);

        // Exit
        System.exit(0);
    }

    private ArrayList<Integer> getDataFromUser()
    {
        ArrayList<Integer> data = new ArrayList<>();

        String input;
        int number;

        // Repeatedly prompt user for data until "done" is entered
        while(true)
        {
            System.out.print("Enter a number: ");
            input = sc.nextLine();

            if(input.equals("done"))
            {
                break;
            }
            else
            {
                // Attempt to parse user input as integer
                try
                {
                    number = Integer.parseInt(input);
                    data.add(number);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Invalid input. Input must be an integer.");
                }
            }
        }

        return data;
    }

    private void displayData(List<Integer> data)
    {
        System.out.println("Numbers: ");

        for(int i = 0; i < data.size(); i++)
        {
            System.out.print(data.get(i));

            // Don't print a comma after the last data point
            if(i < data.size() - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private void displayStatistics(double average, int min, int max, double std)
    {
        System.out.printf("The average is %.1f%n" +
                "The minimum is %d%n" +
                "The maximum is %d%n" +
                "The standard deviation is %.2f%n", average, min, max, std);
    }

    public double average(List<Integer> data)
    {
        double sum = 0;

        for(int i : data)
        {
            sum += i;
        }

        return sum / data.size();
    }

    public int min(List<Integer> data)
    {
        return Collections.min(data);
    }

    public int max(List<Integer> data)
    {
        return Collections.max(data);
    }

    public double std(List<Integer> data)
    {
        double avg = average(data);
        double sumOfSquareDistancesFromAverage = 0;

        for(int i : data)
        {
            sumOfSquareDistancesFromAverage += (Math.abs(i - avg) * Math.abs(i - avg));
        }

        return Math.sqrt(sumOfSquareDistancesFromAverage / data.size());
    }
}
