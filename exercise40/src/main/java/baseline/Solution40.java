/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution 40
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution40
{
    private static final Scanner sc = new Scanner(System.in);

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String POSITION = "position";
    private static final String SEPARATION_DATE = "separationDate";
    private final ArrayList<HashMap<String, String>> employeeList = new ArrayList<>();
    private final ArrayList<HashMap<String, String>> searchResults = new ArrayList<>();

    public static void main(String[] args)
    {
        Solution40 sol = new Solution40();

        // Generate employee database
        sol.generateEmployeeDatabase();

        // Prompt user for search query
        System.out.print("Enter a search string: ");
        String query = sc.nextLine();

        // Generate sub-database of entries related to search query
        sol.searchForQuery(query);

        // Sort search result database
        sol.sortSearchResults();

        // Display search result database
        System.out.print(sol.displaySearchResults());

        // Exit
        System.exit(0);
    }

    public void generateEmployeeDatabase()
    {
        // Create map for first employee
        HashMap<String, String> emp1 = new HashMap<>();

        // Add employee's first name to map
        emp1.put(FIRST_NAME, "John");

        // Add employee's last name to map
        emp1.put(LAST_NAME, "Johnson");

        // Add employee's position to map
        emp1.put(POSITION, "Manager");

        // Add employee's separation date to map
        emp1.put(SEPARATION_DATE, "2016-12-31");

        // Add employee map to list
        employeeList.add(emp1);

        HashMap<String, String> emp2 = new HashMap<>();
        HashMap<String, String> emp3 = new HashMap<>();
        HashMap<String, String> emp4 = new HashMap<>();
        HashMap<String, String> emp5 = new HashMap<>();
        HashMap<String, String> emp6 = new HashMap<>();

        emp2.put(FIRST_NAME, "Tou");
        emp2.put(LAST_NAME, "Xiong");
        emp2.put(POSITION, "Software Engineer");
        emp2.put(SEPARATION_DATE, "2016-10-05");
        employeeList.add(emp2);

        emp3.put(FIRST_NAME, "Michaela");
        emp3.put(LAST_NAME, "Michaelson");
        emp3.put(POSITION, "District Manager");
        emp3.put(SEPARATION_DATE, "2015-12-19");
        employeeList.add(emp3);

        emp4.put(FIRST_NAME, "Jake");
        emp4.put(LAST_NAME, "Jacobson");
        emp4.put(POSITION, "Programmer");
        emp4.put(SEPARATION_DATE, "");
        employeeList.add(emp4);

        emp5.put(FIRST_NAME, "Jacquelyn");
        emp5.put(LAST_NAME, "Jackson");
        emp5.put(POSITION, "DBA");
        emp5.put(SEPARATION_DATE, "");
        employeeList.add(emp5);

        emp6.put(FIRST_NAME, "Sally");
        emp6.put(LAST_NAME, "Webber");
        emp6.put(POSITION, "Web Developer");
        emp6.put(SEPARATION_DATE, "2015-12-18");
        employeeList.add(emp6);
    }

    public void searchForQuery(String query)
    {
        // Search entire database
        for(HashMap<String, String> entry : employeeList)
        {
            // Query matches entry if it matches part (or all) of the first name field or the last name field.
            if(matchPart(entry.get(FIRST_NAME), query) || matchPart(entry.get(LAST_NAME), query))
            {
                searchResults.add(entry);
            }
        }
    }

    private boolean matchPart(String input, String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }

    public void sortSearchResults()
    {
        searchResults.sort(Comparator.comparing(o -> o.get(LAST_NAME)));
    }

    public String displaySearchResults()
    {
        StringBuilder output = new StringBuilder();
        int numCols = 3;

        ArrayList<ArrayList<String>> columns = new ArrayList<>();

        // Initialize columns
        for(int i = 0; i < numCols; i++)
        {
            columns.add(new ArrayList<>());
        }

        int[] columnWidths = new int[numCols];

        // Add column headers
        columns.get(0).add("Name");
        columns.get(1).add(POSITION);
        columns.get(2).add(SEPARATION_DATE);

        // Add data to each column
        for(HashMap<String, String> hs : searchResults)
        {
            columns.get(0).add(hs.get(FIRST_NAME) + " " + hs.get(LAST_NAME));
            columns.get(1).add(hs.get(POSITION));
            columns.get(2).add(hs.get(SEPARATION_DATE));
        }

        // Get widths of each column
        for(int i = 0; i < numCols; i++)
        {
            columnWidths[i] = getColumnWidth(columns.get(i));
        }

        // Insert calculated column widths into row format string
        String rowFormat = "%-" + columnWidths[0] + "s|"
                + "%-" + columnWidths[1] + "s|"
                + "%-" + columnWidths[2] + "s%n";

        // Generate header
        output.append(String.format(rowFormat, "Name", "Position", "Separation Date"));

        // Generate divider
        StringBuilder divider = new StringBuilder();
        for(int i = 0; i < numCols; i++)
        {
            divider.append("-".repeat(columnWidths[i]));

            if(i < numCols - 1)
            {
                divider.append('|');
            }
        }
        divider.append('\n');
        output.append(divider);

        // Generate remaining rows
        for(int i = 1; i < columns.get(0).size(); i++)
        {
            output.append(String.format(rowFormat, columns.get(0).get(i), columns.get(1).get(i), columns.get(2).get(i)));
        }

        return output.toString();
    }

    // Compute minimum column width needed to accommodate a list of strings
    private int getColumnWidth(List<String> list)
    {
        int max = Integer.MIN_VALUE;

        for(String s : list)
        {
            max = Math.max(max, s.length());
        }

        return max + 1;
    }

    public List<HashMap<String, String>> getEmployeeList()
    {
        return employeeList;
    }

    public List<HashMap<String, String>> getSearchResults()
    {
        return searchResults;
    }
}
