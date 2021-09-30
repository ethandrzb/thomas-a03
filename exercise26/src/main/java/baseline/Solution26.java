/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 26
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.Scanner;

public class Solution26
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution26 sol = new Solution26();

        // Prompt user for credit card balance
        double balance = sol.getDoubleFromUser("What is your balance?");

        // Prompt user for card APR
        double apr = sol.getDoubleFromUser("What is the APR on the card (as a percent)?");

        // Prompt user for their monthly payment
        double monthlyPayment = sol.getDoubleFromUser("What is the monthly payment you can make?");

        // Compute number of months needed to pay off card
        PaymentCalculator payCal = new PaymentCalculator(balance, apr, monthlyPayment);

        // Display results
        System.out.println("It will take you " + payCal.calculateMonthsUntilPaidOff()
                + " months to pay off this card.");

        // Exit
        System.exit(0);
    }
    private double getDoubleFromUser(String prompt)
    {
        System.out.print(prompt + " ");

        return sc.nextDouble();
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

        return (int)Math.ceil(-(1.0 / 30.0) * (Math.log(1 + roundToNearestCent(balance / monthlyPayment)
                * (1 - Math.pow(1 + dailyRate, 30)))) / Math.log(1 + dailyRate));
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