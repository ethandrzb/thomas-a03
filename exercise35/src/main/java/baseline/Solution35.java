/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 35
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Solution35
{
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random(System.currentTimeMillis());
    public final List<String> names = new ArrayList<>();

    public static void main(String[] args)
    {
        Solution35 sol = new Solution35();

        // Get names from user
        sol.getNamesFromUser();

        // Get index of winning name
        int indexOfWinningName = sol.generateRandomIndex();

        // Display chosen name
        System.out.println("The winner is... " + sol.selectWinner(sol.names, indexOfWinningName));

        // Exit
        System.exit(0);
    }

    private void getNamesFromUser()
    {
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
    }


    public int generateRandomIndex()
    {
        // Generate a random number to select one of the names entered
        return rand.nextInt(names.size());
    }

    public String selectWinner(List<String> names, int index)
    {
        return names.get(index);
    }
}
