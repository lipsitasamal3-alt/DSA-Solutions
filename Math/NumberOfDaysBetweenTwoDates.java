/*
---------------------------------------------------------
Problem: Number of Days Between Two Dates

Platform: LeetCode

Difficulty: Easy

Approach:
Math + Date Calculation

Algorithm:
1. Convert each date into the total number of days elapsed
   since a fixed starting year (1971).
2. For each date:
   - Extract year, month, and day.
   - Add the days from all previous years.
   - Add the days from all previous months.
   - Add the current day.
3. Take the absolute difference between the two totals.

Leap Year Rule:
A year is a leap year if:
   - It is divisible by 400, OR
   - It is divisible by 4 but not by 100.

Time Complexity:
O(year difference)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/number-of-days-between-two-dates/
---------------------------------------------------------
*/

class Solution {

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1971(date1) - daysFrom1971(date2));
    }

    private int daysFrom1971(String date) {

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] months = {
            0, 31, 28, 31, 30, 31,
            30, 31, 31, 30, 31, 30, 31
        };

        for (int y = 1971; y < year; y++) {
            day += isLeap(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            day += (m == 2 && isLeap(year))
                    ? 29
                    : months[m];
        }

        return day;
    }

    private boolean isLeap(int year) {
        return year % 4 == 0 &&
               (year % 100 != 0 || year % 400 == 0);
    }
}