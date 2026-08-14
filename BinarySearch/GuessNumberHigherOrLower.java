/*
---------------------------------------------------------
Problem: Guess Number Higher or Lower

Platform: LeetCode

Difficulty: Easy

Approach:
Binary Search

Algorithm:
1. Search between 1 and n.
2. Calculate the middle number.
3. Call `guess(mid)`:
   - 0  → found the picked number.
   - -1 → mid is higher than the picked number,
          so search the left half.
   - 1  → mid is lower than the picked number,
          so search the right half.
4. Continue until the number is found.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/guess-number-higher-or-lower/
---------------------------------------------------------
*/

public class Solution extends GuessGame {

    public int guessNumber(int n) {

        int low = 1;
        int high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int res = guess(mid);

            if (res == 0) {
                return mid;

            } else if (res == -1) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}