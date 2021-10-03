/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 37
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

public class Solution37
{
    private enum charClasses {LETTER, SPECIAL, DIGIT}

    public static void main(String[] args)
    {
        // Prompt user for minimum password length

        // Prompt user for number of special characters

        // Prompt user for number of numbers

        // Generate password based on user parameters

        // Display password

        // Exit
    }

    public String generatePassword(int length, int numSpecialChars, int numDigits)
    {
        // Track the following stats during password generation and whether they've reached the user's specifications
            // Length
            // Number of letters
            // Number of special characters
            // Number of digits

        // While there are still specifications to satisfy
            // Randomly select unsatisfied character class
            // Generate next character
            // Add it to the end of the password

        // Return generated password
    }

    public char getRandomCharacterFromClass(charClasses charClass)
    {
        // Randomly select character from specified class

        // Return this character
    }
}
