/*
---------------------------------------------------------
Problem: Day of the Year

Platform: LeetCode

Difficulty: Easy

Approach:
Date Simulation

Algorithm:
1. Extract the year, month, and day from the input string.
2. Store the number of days in each month in an array.
3. Sum the days of all months before the given month.
4. Add the given day to the total.
5. If the year is a leap year and the month is after February,
   add one extra day.
6. Return the total number of days.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/day-of-the-year/
---------------------------------------------------------
*/

class Solution {

    public int dayOfYear(String date) {

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] daysInMonths = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int dayCount = 0;

        for (int i = 0; i < month - 1; i++) {
            dayCount += daysInMonths[i];
        }

        dayCount += day;

        if (month > 2 &&
            ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            dayCount++;
        }

        return dayCount;
    }
}