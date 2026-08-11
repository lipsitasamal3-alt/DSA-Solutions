/*
---------------------------------------------------------
Problem: Majority Element

Platform: LeetCode

Difficulty: Easy

Approach:
Arrays + Boyer-Moore Voting Algorithm

Algorithm:
1. Maintain:
      candidate → possible majority element
      count     → its current vote count

2. When count becomes 0, choose the current number as the
   new candidate.

3. If the current number equals the candidate:
      count++

   Otherwise:
      count--

4. Because the problem guarantees that a majority element
   exists, the final candidate is the majority element.

Why it works:
The majority element appears more than n/2 times, so its votes
cannot be completely cancelled by all other elements.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/majority-element/
---------------------------------------------------------
*/

class Solution {

    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}