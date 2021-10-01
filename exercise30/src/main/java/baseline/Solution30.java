/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 30
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

public class Solution30
{
    public static void main(String[] args)
    {
        Solution30 sol = new Solution30();
        // Generate multiplication table
        String table = sol.generateMultiplicationTable();

        // Display multiplication table
        System.out.print(table);

        // Exit
        System.exit(0);
    }

    private String generateMultiplicationTable()
    {
        StringBuilder table = new StringBuilder();

        final int dimension = 12;

        int padding = getPadding(dimension);

        String row;

        String rowFormat = "%s%" + padding + "s";

        // For each number i in [1, 12]
        for(int i = 1; i <= dimension; i++)
        {
            row = "";

            // Generate row of products
            // For each number j in [1, 12]
            for(int j = 1; j <= dimension; j++)
            {
                // Append i * j to row
                row = String.format(rowFormat, row, i * j);
            }

            // Append row to table
            table.append(row);
            table.append('\n');
        }

        // Return table
        return table.toString();
    }

    private int getPadding(int dimension)
    {
        return (int)Math.ceil(Math.log10(dimension)) + 3;
    }
}
