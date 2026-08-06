/*
---------------------------------------------------------
Problem: Add to Array-Form of Integer

Platform: LeetCode

Difficulty: Easy

Approach:
Simulation

Algorithm:
1. Initialize an empty list to store the result.
2. Start from the last digit of the array.
3. While there are digits remaining in the array or `k` is
   greater than 0:
   - Add the current array digit (if available) to `k`.
   - Append `k % 10` to the result.
   - Update `k` by dividing it by 10.
4. Reverse the result since digits were added from least
   significant to most significant.
5. Return the reversed list.

Time Complexity:
O(max(n, log₁₀(k)))

Space Complexity:
O(max(n, log₁₀(k)))

Link:
https://leetcode.com/problems/add-to-array-form-of-integer/
---------------------------------------------------------
*/

class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> result = new ArrayList<>();

        int i = num.length - 1;

        while (i >= 0 || k > 0) {

            if (i >= 0) {
                k += num[i];
                i--;
            }

            result.add(k % 10);
            k /= 10;
        }

        Collections.reverse(result);

        return result;
    }
}