/*
---------------------------------------------------------
Problem: Missing Number

Platform: LeetCode

Difficulty: Easy

Approach:
Bit Manipulation + XOR

Algorithm:
1. Initialize `missing` with `nums.length`.

2. Traverse the array.

3. For every index `i`, perform XOR with both:
   - The index `i`
   - The array element `nums[i]`

4. XOR has the following properties:
   - `x ^ x = 0`
   - `x ^ 0 = x`

5. Therefore, all numbers that appear both as an index and
   as an array element cancel each other out.

6. The only number left is the missing number.

7. Return `missing`.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/missing-number/
---------------------------------------------------------
*/

class Solution {

    public int missingNumber(int[] nums) {

        // Start with n because indices only go from 0 to n-1
        int missing = nums.length;

        // XOR indices and array elements
        for (int i = 0; i < nums.length; i++) {

            missing ^= i ^ nums[i];
        }

        return missing;
    }
}