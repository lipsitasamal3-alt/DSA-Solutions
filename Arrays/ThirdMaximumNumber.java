/*
---------------------------------------------------------
Problem: Third Maximum Number

Platform: LeetCode

Difficulty: Easy

Approach:
Arrays + Top 3 Distinct Values

Algorithm:
1. Maintain three variables:
      first  → largest distinct value
      second → second largest distinct value
      third  → third largest distinct value

2. Ignore duplicate values.

3. For every number:
   - If it is greater than `first`, shift:
        first → second
        second → third
   - Otherwise, if it is greater than `second`, shift:
        second → third
   - Otherwise, if it is greater than `third`, update `third`.

4. If there are fewer than three distinct values, return the
   largest value (`first`).

Why Long?
`Long` is used so that `null` can represent an uninitialized
value and to safely compare against the integer range.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/third-maximum-number/
---------------------------------------------------------
*/

class Solution {

    public int thirdMax(int[] nums) {

        Long first = null;
        Long second = null;
        Long third = null;

        for (int num : nums) {

            long current = num;

            // Ignore duplicates
            if ((first != null && current == first) ||
                (second != null && current == second) ||
                (third != null && current == third)) {

                continue;
            }

            if (first == null || current > first) {

                third = second;
                second = first;
                first = current;

            } else if (second == null || current > second) {

                third = second;
                second = current;

            } else if (third == null || current > third) {

                third = current;
            }
        }

        return third == null
                ? first.intValue()
                : third.intValue();
    }
}