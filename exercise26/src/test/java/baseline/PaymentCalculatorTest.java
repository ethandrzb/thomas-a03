/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 26 Test
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentCalculatorTest
{
    @Test
    void PaymentCalculatorConstructor()
    {
        PaymentCalculator pcal = new PaymentCalculator(5000, 12, 100);

        assertEquals(5000.0, pcal.getBalance(), 0.00001);
        assertEquals(3.0 / 9125.0, pcal.getDailyRate(), 0.00001);
        assertEquals(100.0, pcal.getMonthlyPayment(), 0.00001);
    }

    @Test
    void calculateMonthsUntilPaidOff()
    {
        PaymentCalculator pcal = new PaymentCalculator(5000, 12, 100);

        assertEquals(70, pcal.calculateMonthsUntilPaidOff());
    }
}