/*
---------------------------------------------------------
Problem: Angle Between Hands of a Clock

Platform: LeetCode

Difficulty: Medium

Approach:
Math + Geometry

Algorithm:
1. Calculate the minute hand's angle:
      minutes × 6
   because each minute represents 6 degrees.

2. Calculate the hour hand's angle:
      (hour % 12) × 30 + minutes × 0.5

   The `minutes × 0.5` accounts for the hour hand moving
   continuously as the minutes pass.

3. Find the absolute difference between the two angles.

4. There are two possible angles between the hands:
      diff
      360 - diff

5. Return the smaller one.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/angle-between-hands-of-a-clock/
---------------------------------------------------------
*/

class Solution {

    public double angleClock(int hour, int minutes) {

        double minuteAngle = minutes * 6.0;

        double hourAngle =
                (hour % 12) * 30.0 + minutes * 0.5;

        double diff = Math.abs(hourAngle - minuteAngle);

        return Math.min(diff, 360.0 - diff);
    }
}