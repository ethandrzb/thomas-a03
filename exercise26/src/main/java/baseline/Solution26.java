/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 26
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

public class Solution26
{
    public static void main(String[] args)
    {
        // Prompt user for credit card balance

        // Store input as double

        // Prompt user for card APR

        // Store input as double

        // Prompt user for their monthly payment

        // Store input as double

        // Compute number of months needed to pay off card

        // Display results
    }
}

class PaymentCalculator
{
    private final double balance;
    private final double APR;
    private final double monthlyPayment;

    private final double dailyRate;

    public PaymentCalculator(double balance, double APR, double monthlyPayment)
    {
        // Assign instance vars

        // Compute daily rate
    }

    public int calculateMonthsUntilPaidOff()
    {
        // Compute number of months until card is paid off
    }

    private double roundToNearestCent(double amount)
    {
        // Round to nearest penny
    }
}