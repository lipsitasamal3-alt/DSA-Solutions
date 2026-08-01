/*
---------------------------------------------------------
Problem: Bulb Switcher

Platform: LeetCode

Difficulty: Medium

Approach:
Math

Algorithm:
1. Observe that a bulb is toggled once for each of its divisors.
2. A bulb remains ON only if it is toggled an odd number of times.
3. Only perfect squares have an odd number of divisors.
4. Count the perfect squares less than or equal to n.
5. Return ⌊√n⌋.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/bulb-switcher/
---------------------------------------------------------
*/

class Solution {

    public int bulbSwitch(int n) {

        return (int) Math.sqrt(n);
    }
}