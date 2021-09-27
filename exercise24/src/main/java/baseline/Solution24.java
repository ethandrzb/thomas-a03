/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 24
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.HashMap;
import java.util.Scanner;

public class Solution24
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution24 sol = new Solution24();

        // Print program instructions
        System.out.println("Enter two strings and I'll tell you if they are anagrams: ");

        // Prompt for first string
        // Store input as string
        String str1 = sol.getStringFromUser("Enter the first string");

        // Prompt for second string
        // Store input as string
        String str2 = sol.getStringFromUser("Enter the second string");

        // Determine whether the two strings are anagrams and print appropriate response
        if(sol.isAnagram(str1, str2))
        {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        }
        else
        {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }

        // Exit
        System.exit(0);
    }

    private String getStringFromUser(String prompt)
    {
        System.out.print(prompt + ": ");

        return sc.nextLine();
    }

    public boolean isAnagram(String str1, String str2)
    {
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Check lengths of str1 and str2. If they don't match, they can't be anagrams.
        if(str1.length() == str2.length())
        {
            // Find all characters present in str1 and their frequencies
            for(Character c : str1.toUpperCase().toCharArray())
            {
                if(freq1.containsKey(c))
                {
                    freq1.put(c, freq1.get(c) + 1);
                }
                else
                {
                    freq1.put(c, 1);
                }
            }

            // Find all characters present in str2 and their frequencies
            for(Character c : str2.toUpperCase().toCharArray())
            {
                if(freq2.containsKey(c))
                {
                    freq2.put(c, freq2.get(c) + 1);
                }
                else
                {
                    freq2.put(c, 1);
                }
            }

            // Compare characters and frequencies.
            for(char letter : alphabet.toCharArray())
            {
                // Letter exists in both, but at different frequencies
                if(freq1.containsKey(letter) && freq2.containsKey(letter)
                        && (!freq1.get(letter).equals(freq2.get(letter)))

                        // Letter exists in one, but not the other
                        || (freq1.containsKey(letter) != freq2.containsKey(letter)))
                {
                    return false;
                }
            }
            // No mismatches were found, so str1 and str2 are anagrams

            return true;
        }

        return false;
    }
}
