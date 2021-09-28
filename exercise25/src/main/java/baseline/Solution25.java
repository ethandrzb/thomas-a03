/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 25
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        // Password Strength Scale
        // Name         | Value
        //-----------------------
        // Very weak    | 0
        // Weak         | 1
        // Strong       | 2
        // Very strong  | 3

        // If password length is less than 8 characters
        if(password.length() < 8)
        {
            // Check if password is very weak
            if(isVeryWeak(password))
            {
                // If so, return 0 (very weak)

                return 0;
            }
            else
            {
                // If not, check if password is weak
                // If so, return 1 (weak)
                // If not, return -1 (unknown strength)

                return isWeak(password) ? 1 : -1;
            }
        }
        else
        {
            // Else
            // Check if password is very strong
            // CHANGE THIS
            if(false)
            {
                // If so, return 3
                return 3;
            }
            // If not, check if password is strong
            else
            {
                // If so, return 2 (strong)
                // Else, return -1 (unknown strength)
                return isStrong(password) ? 2 : -1;
            }

        }
    }

    private boolean match(String input, String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    private boolean isVeryWeak(String password)
    {
        // Check if password only contains numbers (very weak)

        return match(password, "^\\d+$");
    }

    private boolean isWeak(String password)
    {
        // Check if password only contains letters (weak)

        return match(password, "^[a-zA-Z]+$");
    }
//
    private boolean isStrong(String password)
    {
        // Check if password contains letters, and at least one number (strong)

        // Match only alphanumeric passwords

        return match(password, "^[a-zA-Z\\d]+$\"")

                // Make sure password has at least one digit
                && match(password, "\\d+");
    }
//
//    private boolean isVeryStrong(String password)
//    {
//        // Check if password contains letters, numbers, and special characters (very strong)
//
//        // This approach starts by checking that a password matches at least one of 3 cases (first regex)
//        // Afterwards, each case is checked individually (remaining regexes)
//
//        // Match passwords with alphanumeric and special characters
//        // Regex = "[a-zA-Z\d !"#$%&'()*+,\-./:;<=>?@[\]^_`{|}~]+"
//
//        // Make sure password has letters
//        // Regex = "[a-zA-Z]+"
//
//        // Make sure password has numbers
//        // Regex = "\d+"
//
//        // Make sure password has special characters
//        // Regex = "[ !"#$%&'()*+,\-./:;<=>?@[\]^_`{|}~]+"
//    }
}
