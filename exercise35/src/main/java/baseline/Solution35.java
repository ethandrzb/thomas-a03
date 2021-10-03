/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 35
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Solution35
{
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random(System.currentTimeMillis());

    public static void main(String[] args)
    {
        Solution35 sol = new Solution35();

        // Get names from user
        ArrayList<String> names = sol.getNamesFromUser();

        // Get index of winning name
        int indexOfWinningName = sol.generateRandomIndex(names);

        // Display chosen name
        System.out.println("The winner is... " + names.get(indexOfWinningName));

        // Exit
        System.exit(0);
    }

    private ArrayList<String> getNamesFromUser()
    {
        ArrayList<String> names = new ArrayList<>();
        String input;

        // Repeatedly prompt a user to enter a name until the name they enter is blank
        while(true)
        {
            System.out.print("Enter a name: ");
            input = sc.nextLine();
            if(!input.isEmpty())
            {
                names.add(input);
            }
            else
            {
                break;
            }
        }

        return names;
    }

    private int generateRandomIndex(ArrayList<String> names)
    {
        // Generate a random number to select one of the names entered
        return rand.nextInt(names.size());
    }
}
