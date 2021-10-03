/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 37
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.*;

public class Solution37
{
    private static final String ALPHABET_BOTH_CASES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIALS = "!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~";

    private static final ArrayList<Character> alphabet = new ArrayList<>();
    private static final ArrayList<Character> digits = new ArrayList<>();
    private static final ArrayList<Character> specialCharacters = new ArrayList<>();

    private int lettersAdded = 0;
    private int digitsAdded = 0;
    private int specialCharsAdded = 0;

    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random(System.currentTimeMillis());
    private enum charClass {LETTER, SPECIAL, DIGIT}

    public static void main(String[] args)
    {
        Solution37 sol = new Solution37();

        sol.initPasswordCharLists();

        // Prompt user for minimum password length
        int length = sol.getIntFromUser("What's the minimum length?");

        // Prompt user for number of special characters
        int specialChars = sol.getIntFromUser("How many special characters?");

        // Prompt user for number of numbers
        int numDigits = sol.getIntFromUser("How many digits?");

        // Generate password based on user parameters
        String password = sol.generatePassword(length, specialChars, numDigits);

        // Display password
        System.out.println("Your password is " + password);

        // Exit
        System.exit(0);
    }

    // Convert Strings to ArrayLists of characters to satisfy requirement
    private void initPasswordCharLists()
    {
        for(char c : ALPHABET_BOTH_CASES.toCharArray())
        {
            alphabet.add(c);
        }

        for(char c : NUMBERS.toCharArray())
        {
            digits.add(c);
        }

        for(char c : SPECIALS.toCharArray())
        {
            specialCharacters.add(c);
        }
    }

    private int getIntFromUser(String prompt)
    {
        int value;

        while(true)
        {
            System.out.print(prompt + " ");

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

    private ArrayList<charClass> initCharClassesNeeded()
    {
        ArrayList<charClass> classesNeeded = new ArrayList<>();

        classesNeeded.add(charClass.LETTER);
        classesNeeded.add(charClass.DIGIT);
        classesNeeded.add(charClass.SPECIAL);

        return classesNeeded;
    }

    public String generatePassword(int length, int specialChars, int digits)
    {
        StringBuilder password = new StringBuilder();
        ArrayList<charClass> classesNeeded = initCharClassesNeeded();
        charClass selectedClass;
        char nextChar;

        // Track the following stats during password generation and whether they've reached the user's specifications
            // Number of letters
            // Number of special characters
            // Number of digits

        // While there are still specifications to satisfy
        while((password.length() <= length)
                || needMoreLetters()
                || needMoreSpecials(specialChars)
                || needMoreDigits(digits))
        {
            // Remove classes from selection pool once they're satisfied
            if(!needMoreDigits(digits))
            {
                classesNeeded.remove(charClass.DIGIT);
            }
            if(!needMoreSpecials(specialChars))
            {
                classesNeeded.remove(charClass.SPECIAL);
            }

            // Randomly select unsatisfied character class
            selectedClass = getRandomCharClass(classesNeeded);

            // Generate next character
            nextChar = getRandomCharacterFromClass(selectedClass);

            // Add it to the end of the password
            password.append(nextChar);

            // Update running stats
            updateStats(selectedClass);

            System.out.println("\nChar classes remaining: " + classesNeeded);
            System.out.println(needMoreLetters() + " " + needMoreSpecials(specialChars) + " " + needMoreDigits(digits));
        }

        // Return generated password
        return password.toString();
    }

    public void updateStats(charClass selectedClass)
    {
        switch(selectedClass)
        {
            case LETTER -> lettersAdded++;
            case DIGIT -> digitsAdded++;
            case SPECIAL -> specialCharsAdded++;
        }
    }

    private boolean needMoreLetters()
    {
        return lettersAdded < (digitsAdded + specialCharsAdded);
    }

    private boolean needMoreDigits(int digits)
    {
        return digitsAdded < digits;
    }

    private boolean needMoreSpecials(int specialChars)
    {
        return specialCharsAdded < specialChars;
    }

    public charClass getRandomCharClass(List<charClass> charClassesNeeded)
    {
        int index = rand.nextInt(charClassesNeeded.size());

        return charClassesNeeded.get(index);
    }

    public char getRandomCharacterFromClass(charClass charClass)
    {
        ArrayList<Character> selectedCharSet = switch(charClass)
                {
                    case LETTER -> alphabet;
                    case DIGIT -> digits;
                    case SPECIAL -> specialCharacters;
                };

        // Randomly select index in selected character set
        int index = rand.nextInt(selectedCharSet.size());

        // Return the character in the selected character set at this index
        return selectedCharSet.get(index);
    }
}