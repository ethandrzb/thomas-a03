/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 37 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class Solution37Test
{
    Solution37 sol;

    @BeforeEach
    void initEach()
    {
        sol = new Solution37();
    }

    private int getNumMatches(String input, String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int numMatches = 0;

        while(matcher.find())
        {
            numMatches++;
        }

        return numMatches;
    }

    @Test
    void generatePassword()
    {
        int length = 16;
        int specialChars = 4;
        int digits = 7;

        String password = sol.generatePassword(length, specialChars, digits);

        assertTrue(password.length() >= length);
        assertEquals(specialChars, getNumMatches(password, "[ !\"#$%&'()*+,\\-./:;<=>?@\\[\\]^_`{|}~]"));
        assertEquals(digits, getNumMatches(password, "\\d"));
    }

    @Test
    void updateStats()
    {
        assertEquals(0, sol.getLettersAdded());
        assertEquals(0, sol.getSpecialCharsAdded());
        assertEquals(0, sol.getDigitsAdded());

        sol.updateStats(Solution37.charClass.LETTER);

        assertEquals(1, sol.getLettersAdded());
        assertEquals(0, sol.getSpecialCharsAdded());
        assertEquals(0, sol.getDigitsAdded());

        sol.updateStats(Solution37.charClass.DIGIT);

        assertEquals(1, sol.getLettersAdded());
        assertEquals(0, sol.getSpecialCharsAdded());
        assertEquals(1, sol.getDigitsAdded());

        sol.updateStats(Solution37.charClass.LETTER);

        assertEquals(2, sol.getLettersAdded());
        assertEquals(0, sol.getSpecialCharsAdded());
        assertEquals(1, sol.getDigitsAdded());

        sol.updateStats(Solution37.charClass.SPECIAL);

        assertEquals(2, sol.getLettersAdded());
        assertEquals(1, sol.getSpecialCharsAdded());
        assertEquals(1, sol.getDigitsAdded());
    }

//    @Test
//    void getRandomCharClass()
//    {
//
//    }
//
//    @Test
//    void getRandomCharacterFromClass()
//    {
//
//    }
}