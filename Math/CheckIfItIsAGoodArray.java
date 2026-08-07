/*
---------------------------------------------------------
Problem: Check If It Is a Good Array

Platform: LeetCode

Difficulty: Hard

Approach:
Math + GCD (Bézout's Identity)

Algorithm:
1. Initialize the running GCD with the first element.
2. Traverse the array:
   - Update the running GCD with the current element.
   - If the running GCD becomes 1, return true immediately.
3. After processing all elements:
   - Return true if the final GCD is 1.
   - Otherwise, return false.

Explanation:
According to Bézout's Identity, an array is "good" if and only if
the GCD of all its elements is 1. In that case, it is possible to
form the value 1 using an integer linear combination of the array
elements.

Helper Function:
1. Compute the GCD of two numbers using the Euclidean algorithm.
2. Repeat until the remainder becomes 0.
3. Return the final GCD.

Time Complexity:
O(n × log(max(nums)))

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/check-if-it-is-a-good-array/
---------------------------------------------------------
*/

class Solution {

    public boolean isGoodArray(int[] nums) {

        int runningGcd = nums[0];

        for (int num : nums) {

            runningGcd = gcd(runningGcd, num);

            if (runningGcd == 1) {
                return true;
            }
        }

        return runningGcd == 1;
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}