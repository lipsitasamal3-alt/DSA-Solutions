/*
---------------------------------------------------------
Problem: Summary Ranges

Platform: LeetCode

Difficulty: Easy

Approach:
Array Traversal

Algorithm:
1. Create an empty list to store the summary ranges.
2. If the array is empty, return the empty list.
3. Set the first element as the start of the current range.
4. Traverse the array:
   - If the current element is the last element, or the next
     element is not consecutive:
       - If the range contains only one number, add it as a string.
       - Otherwise, add the range in the form "start->end".
       - If more elements remain, start a new range from the next
         element.
5. Return the list of summary ranges.

Time Complexity:
O(n)

Space Complexity:
O(1) (excluding the output list)

Link:
https://leetcode.com/problems/summary-ranges/
---------------------------------------------------------
*/

class Solution {

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {

                if (start == nums[i]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i]);
                }

                if (i < nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }

        return result;
    }
}