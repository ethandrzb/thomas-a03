/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 25
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution25
{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        Solution25 sol = new Solution25();

        // Prompt user for their password
        System.out.print("Enter your password to analyze its strength: ");

        String userPassword = sc.nextLine();

        // Display appropriate response based on password strength
        System.out.println(sol.generatePasswordReport(userPassword));

        // Exit
        System.exit(0);
    }
    private String strengthNumberToName(int strength)
    {
        return switch (strength) {
            case 0 -> "very weak";
            case 1 -> "weak";
            case 2 -> "strong";
            case 3 -> "very strong";
            default -> "unknown strength";
        };
    }

    public String generatePasswordReport(String password)
    {
        // Determine strength of password
        int strength = passwordValidator(password);

        if(strength == -1)
        {
            return "The password '" + password + "' is of unknown strength.";
        }
        else
        {
            return "The password '" + password + "' is a " + strengthNumberToName(strength) + " password.";
        }
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
            // Need to check for very strong before strong, because very strong passwords are also strong passwords.
            if(isVeryStrong(password))
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

    private boolean match(String input, String regex, boolean mustMatchEntireString)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if(mustMatchEntireString)
        {
            return matcher.matches();
        }
        else
        {
            return matcher.find();
        }
    }

    private boolean isVeryWeak(String password)
    {
        // Check if password only contains numbers (very weak)

        return match(password, "^\\d+$", true);
    }

    private boolean isWeak(String password)
    {
        // Check if password only contains letters (weak)

        return match(password, "^[a-zA-Z]+$", true);
    }
//
    private boolean isStrong(String password)
    {
        // Check if password contains letters, and at least one number (strong)

        // Match only alphanumeric passwords

        return match(password, "^[a-zA-Z\\d]+$", true)

                // Make sure password has at least one digit
                && match(password, "\\d+", false);
    }

    private boolean isVeryStrong(String password)
    {
        // Check if password contains letters, numbers, and special characters (very strong)

        // This approach starts by checking that a password matches at least one of 3 cases (first regex)
        // Afterwards, each case is checked individually (remaining regexes)

        // Match passwords with alphanumeric and special characters
        return match(password, "[a-zA-Z\\d !\"#$%&'()*+,\\-./:;<=>?@\\[\\]^_`{|}~]+", true)

        // Make sure password has letters
                    && match(password, "[a-zA-Z]+", false)

        // Make sure password has numbers
                    && match(password, "\\d+", false)

        // Make sure password has special characters
                    && match(password,"[ !\"#$%&'()*+,\\-./:;<=>?@\\[\\]^_`{|}~]+" , false);
    }
}
