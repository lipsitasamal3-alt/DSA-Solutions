/*
---------------------------------------------------------
Problem: Self Dividing Numbers

Platform: LeetCode

Difficulty: Easy

Approach:
Math

Algorithm:
1. Initialize an empty list to store the result.
2. Iterate through every number from `left` to `right`.
3. For each number:
   - Check whether every digit is non-zero.
   - Verify that the original number is divisible by each of its
     digits.
   - If all digits satisfy the condition, add the number to the
     result list.
4. Return the result list.

Helper Function:
1. Copy the current number into a temporary variable.
2. Extract each digit using modulo 10.
3. If a digit is 0 or the number is not divisible by the digit,
   return false.
4. Remove the last digit and continue.
5. If all digits pass the checks, return true.

Time Complexity:
O((right - left + 1) × d)
where d is the number of digits.

Space Complexity:
O(1) (excluding the output list)

Link:
https://leetcode.com/problems/self-dividing-numbers/
---------------------------------------------------------
*/

class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isSelfDividing(int num) {

        int temp = num;

        while (temp > 0) {

            int digit = temp % 10;

            if (digit == 0 || num % digit != 0) {
                return false;
            }

            temp /= 10;
        }

        return true;
    }
}