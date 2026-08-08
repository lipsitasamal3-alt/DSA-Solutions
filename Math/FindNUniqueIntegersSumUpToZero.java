/*
---------------------------------------------------------
Problem: Find N Unique Integers Sum up to Zero

Platform: LeetCode

Difficulty: Easy

Approach:
Math + Construction

Algorithm:
1. Create an array of size n.
2. Generate pairs:
      +1, -1
      +2, -2
      +3, -3
      ...
   Each pair has a sum of 0.
3. If n is odd, add 0 as the final element.
4. Return the array.

Example:
n = 5

Result:
[1, -1, 2, -2, 0]

Sum = 1 - 1 + 2 - 2 + 0 = 0

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
---------------------------------------------------------
*/

class Solution {

    public int[] sumZero(int n) {

        int[] result = new int[n];
        int index = 0;

        for (int i = 1; i <= n / 2; i++) {
            result[index++] = i;
            result[index++] = -i;
        }

        if (n % 2 != 0) {
            result[index] = 0;
        }

        return result;
    }
}