/*
---------------------------------------------------------
Problem: Majority Element II

Platform: LeetCode

Difficulty: Medium

Approach:
Boyer-Moore Voting Algorithm

Algorithm:
1. There can be at most two elements that appear more than
   n / 3 times in the array.

2. Maintain two candidates:
   - `candidate1` with `count1`
   - `candidate2` with `count2`

3. First pass:
   - If the current number matches a candidate, increase
     its count.
   - If a candidate has zero count, assign the current number
     to that candidate.
   - Otherwise, decrease both counts.

4. The first pass only finds possible candidates. They are
   not guaranteed to actually occur more than n / 3 times.

5. Perform a second pass to count the actual occurrences of
   both candidates.

6. Add a candidate to the result if its frequency is greater
   than n / 3.

7. Return the resulting list.

Time Complexity:
O(n)

Space Complexity:
O(1)
(Excluding the output list.)

Link:
https://leetcode.com/problems/majority-element-ii/
---------------------------------------------------------
*/

class Solution {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Integer candidate1 = null;
        Integer candidate2 = null;

        int count1 = 0;
        int count2 = 0;

        // First pass: Find possible candidates
        for (int num : nums) {

            if (candidate1 != null && num == candidate1) {

                count1++;

            } else if (candidate2 != null && num == candidate2) {

                count2++;

            } else if (count1 == 0) {

                candidate1 = num;
                count1 = 1;

            } else if (count2 == 0) {

                candidate2 = num;
                count2 = 1;

            } else {

                // Cancel one occurrence of both candidates
                count1--;
                count2--;
            }
        }

        // Second pass: Verify actual frequencies
        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (candidate1 != null && num == candidate1) {
                count1++;

            } else if (candidate2 != null && num == candidate2) {
                count2++;
            }
        }

        int target = nums.length / 3;

        // Add candidates that actually occur more than n / 3 times
        if (count1 > target) {
            result.add(candidate1);
        }

        if (count2 > target) {
            result.add(candidate2);
        }

        return result;
    }
}