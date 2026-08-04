/*
---------------------------------------------------------
Problem: Day of the Week

Platform: LeetCode

Difficulty: Easy

Approach:
Date Simulation

Algorithm:
1. Store the names of the days of the week.
2. Store the number of days in each month.
3. Count the total number of days from
   January 1, 1971 to the given date:
   - Add the days in each complete year.
   - Add the days in each complete month of the current year.
   - Add the remaining days of the current month.
4. Account for leap years when calculating February.
5. Since January 1, 1971 was a Friday, use an offset of 5.
6. Return the day corresponding to:
      (totalDays + 5) % 7

Time Complexity:
O(year - 1971)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/day-of-the-week/
---------------------------------------------------------
*/

class Solution {

    public String dayOfTheWeek(int day, int month, int year) {

        String[] days = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int totalDays = 0;

        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            if (m == 2 && isLeapYear(year)) {
                totalDays += 29;
            } else {
                totalDays += daysInMonth[m - 1];
            }
        }

        totalDays += day - 1;

        return days[(totalDays + 5) % 7];
    }

    private boolean isLeapYear(int year) {

        return (year % 4 == 0 && year % 100 != 0)
                || (year % 400 == 0);
    }
}