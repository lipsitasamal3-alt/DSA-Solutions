/*
---------------------------------------------------------
Problem: Find the Number of Distinct Even Numbers

Platform: LeetCode

Difficulty: Easy

Approach:
Array Frequency Counting

Algorithm:
1. Count the frequency of each digit (0–9) in the input array.
2. Iterate through all three-digit even numbers (100 to 998).
3. For each number:
   - Extract its hundreds, tens, and ones digits.
   - Temporarily decrease their frequencies.
4. If all frequencies remain non-negative:
   - The number can be formed.
   - Increment the answer.
5. Restore the digit frequencies.
6. Return the total count of distinct even numbers.

Time Complexity:
O(1)
(Checks only 450 three-digit even numbers.)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/find-the-number-of-distinct-even-numbers/
---------------------------------------------------------
*/

class Solution {

    public int totalNumbers(int[] digits) {

        int[] digitCounts = new int[10];

        for (int digit : digits) {
            digitCounts[digit]++;
        }

        int distinctEvenCount = 0;

        for (int num = 100; num < 1000; num += 2) {

            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            digitCounts[d1]--;
            digitCounts[d2]--;
            digitCounts[d3]--;

            if (digitCounts[d1] >= 0 &&
                digitCounts[d2] >= 0 &&
                digitCounts[d3] >= 0) {

                distinctEvenCount++;
            }

            digitCounts[d1]++;
            digitCounts[d2]++;
            digitCounts[d3]++;
        }

        return distinctEvenCount;
    }
}