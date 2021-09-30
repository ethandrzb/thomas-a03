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

        // Exit
        System.exit(0);
    }
}

class PaymentCalculator
{
    private final double balance;
    private final double monthlyPayment;

    private final double dailyRate;

    public PaymentCalculator(double balance, double apr, double monthlyPayment)
    {
        // Assign instance vars
        this.balance = balance;
        this.monthlyPayment = monthlyPayment;

        // Convert apr from percentage to factor
        // E.g. 5 ==> 0.05
        apr /= 100;

        // Compute daily rate
        dailyRate = apr / 365;
    }

    public int calculateMonthsUntilPaidOff()
    {
        // Compute number of months until card is paid off

        return (int)Math.ceil(-(1.0 / 30.0) * (Math.log(1 + roundToNearestCent(balance / monthlyPayment) * (1 - Math.pow(1 + dailyRate, 30)))) / Math.log(1 + dailyRate));
    }

    private double roundToNearestCent(double amount)
    {
        // Round up to next penny
        amount *= 1000;
        amount = Math.ceil(amount);
        amount /= 10;
        amount = Math.ceil(amount);
        amount /= 100;

        return amount;
    }

    public double getBalance()
    {
        return balance;
    }

    public double getMonthlyPayment()
    {
        return monthlyPayment;
    }

    public double getDailyRate()
    {
        return dailyRate;
    }
}