/*
---------------------------------------------------------
Problem: Happy Number

Platform: LeetCode

Difficulty: Easy

Approach:
HashSet + Digit Manipulation

Algorithm:
1. A happy number eventually reaches `1` when repeatedly
   replaced by the sum of the squares of its digits.

2. Use a HashSet called `seen` to store numbers that have
   already appeared.

3. Continue calculating the sum of squared digits while:
   - `n` is not 1.
   - `n` has not been seen before.

4. If a number appears again, a cycle exists, meaning the
   number will never reach 1.

5. The helper method `getNext()` calculates the sum of the
   squares of the digits of the current number.

6. Return `true` if the process reaches 1; otherwise return
   `false`.

Time Complexity:
O(log n) per transformation

Overall complexity is bounded because the digit-square
process quickly reaches either 1 or a repeating cycle.

Space Complexity:
O(log n)
(The HashSet stores numbers encountered in the cycle.)

Link:
https://leetcode.com/problems/happy-number/
---------------------------------------------------------
*/

class Solution {

    public boolean isHappy(int n) {

        // Store previously seen numbers to detect cycles
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {

            // Mark the current number as seen
            seen.add(n);

            // Calculate the next number
            n = getNext(n);
        }

        // If n reaches 1, it is a happy number
        return n == 1;
    }

    // Calculate the sum of squares of the digits
    private int getNext(int n) {

        int totalSum = 0;

        while (n > 0) {

            int digit = n % 10;

            totalSum += digit * digit;

            n /= 10;
        }

        return totalSum;
    }
}