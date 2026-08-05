/*
---------------------------------------------------------
Problem: Kth Smallest Number in Multiplication Table

Platform: LeetCode

Difficulty: Hard

Approach:
Binary Search

Algorithm:
1. Set the search range:
   - low = 1
   - high = m × n
2. While low is less than high:
   - Compute the middle value.
   - Count how many numbers in the multiplication table are
     less than or equal to the middle value.
   - If the count is at least k, the answer lies in the left
     half (including mid).
   - Otherwise, search the right half.
3. Return low, which represents the kth smallest number.

Helper Function:
1. For each row i (1 to m):
   - Count how many numbers are ≤ x using:
       min(x / i, n)
2. Sum these counts across all rows.

Time Complexity:
O(m × log(m × n))

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
---------------------------------------------------------
*/

class Solution {

    public int findKthNumber(int m, int n, int k) {

        int low = 1;
        int high = m * n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (countLessOrEqual(mid, m, n) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int countLessOrEqual(int x, int m, int n) {

        int count = 0;

        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }

        return count;
    }
}