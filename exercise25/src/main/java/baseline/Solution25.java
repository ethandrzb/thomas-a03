/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 25
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

        // Exit
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

        // Regex = "/^\d+$/g"
    }

    private boolean isWeak(String password)
    {
        // Check if password only contains letters (weak)

        // Regex = "/^[a-zA-Z\D]+$/g"
    }

    private boolean isString(String password)
    {
        // Check if password contains letters, and at least one number (strong)

        // Match only alphanumeric passwords
        // Regex = "/^[a-zA-Z\d]+$/g"

        // Make sure password has at least one digit
        // Regex = "/\d+/g"
    }

    private boolean isVeryStrong(String password)
    {
        // Check if password contains letters, numbers, and special characters (very strong)

        // This approach starts by checking that a password matches at least one of 3 cases (first regex)
        // Afterwards, each case is checked individually (remaining regexes)

        // Match passwords with alphanumeric and special characters
        // Regex = "/[a-zA-Z\d !"#$%&'()*+,\-./:;<=>?@[\]^_`{|}~]+/g"

        // Make sure password has letters
        // Regex = "/[a-zA-Z]+/g"

        // Make sure password has numbers
        // Regex = "/\d+/g"

        // Make sure password has special characters
        // Regex = "/[ !"#$%&'()*+,\-./:;<=>?@[\]^_`{|}~]+/g"
    }
}
