/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 24
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

public class Solution25
{
    public static void main(String[] args)
    {
        // Prompt user for their password

        // Determine strength of password

        // Display appropriate response based on password strength
    }
    public int passwordValidator(String password)
    {
        // Get password length
        // If length < 8 characters
            // Check if password is very weak
            // If so, return 0 (very weak)
            // If not, check if password is weak
                // If so, return 1 (weak)
                // If not, return -1 (unknown strength)
        // Else
            // Check if password is very strong
            // If so, return 3
            // If not, check if password is strong
                // If so, return 2 (strong)
                // Else, return -1 (unknown strength)
    }

    private boolean isVeryWeak(String password)
    {
        // Check if password only contains numbers (very weak)
    }

    private boolean isWeak(String password)
    {
        // Check if password only contains letters (weak)
    }

    private boolean isString(String password)
    {
        // Check if password contains letters, and at least one number (strong)
    }

    private boolean isVeryStrong(String password)
    {
        // Check if password contains letters, numbers, and special characters (very strong)
    }
}
