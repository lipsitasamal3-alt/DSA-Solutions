/*
---------------------------------------------------------
Problem: Find Smallest Letter Greater Than Target

Platform: LeetCode

Difficulty: Easy

Approach:
Binary Search

Algorithm:
1. Initialize `low` and `high` to represent the search
   range of the sorted letters array.

2. Perform binary search.

3. If letters[mid] <= target:
   - The current letter is not a valid answer.
   - Search in the right half by moving `low` forward.

4. Otherwise:
   - letters[mid] is greater than target.
   - Store it as a possible answer by moving `high`
     to the left.

5. When the binary search ends, `low` points to the first
   letter strictly greater than target.

6. If `low` reaches the end of the array, use:
   `low % letters.length`
   to wrap around to the first letter.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/find-smallest-letter-greater-than-target/
---------------------------------------------------------
*/

class Solution {

    public char nextGreatestLetter(char[] letters, char target) {

        int low = 0;
        int high = letters.length - 1;

        // Binary search for the first letter greater than target
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (letters[mid] <= target) {

                // Search in the right half
                low = mid + 1;

            } else {

                // Search for a smaller valid letter
                high = mid - 1;
            }
        }

        // Wrap around if no greater letter exists
        return letters[low % letters.length];
    }
}