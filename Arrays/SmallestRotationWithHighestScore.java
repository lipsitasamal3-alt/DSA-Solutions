/*
---------------------------------------------------------
Problem: Smallest Rotation with Highest Score

Platform: LeetCode

Difficulty: Hard

Approach:
Difference Array + Prefix Sum

Algorithm:
1. For each element `nums[i]`, determine the range of
   rotations where this element does NOT contribute to the
   score.

2. Calculate:
   - `low` = first rotation where the element becomes invalid.
   - `high` = rotation boundary where its effect ends.

3. Use a difference array `change` to efficiently record
   how the score changes across rotations.

4. Calculate the score for rotation `K = 0`.

5. Traverse rotations from `1` to `n - 1` and update the
   current score using the difference array.

6. Whenever the current score becomes greater than the
   maximum score found so far, update `bestK`.

7. Since we only update when the score is strictly greater,
   the smallest rotation with the highest score is retained.

8. Return `bestK`.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/smallest-rotation-with-highest-score/
---------------------------------------------------------
*/

class Solution {

    public int bestRotation(int[] nums) {

        int n = nums.length;

        // Difference array to store score changes
        int[] change = new int[n];

        // Determine the score range for every element
        for (int i = 0; i < n; i++) {

            int low = (i - nums[i] + 1 + n) % n;
            int high = (i + 1) % n;

            change[low]--;
            change[high]++;
        }

        int currentScore = 0;

        // Calculate score for rotation K = 0
        for (int i = 0; i < n; i++) {

            if (nums[i] <= i) {
                currentScore++;
            }
        }

        int maxScore = currentScore;
        int bestK = 0;

        // Calculate scores for all rotations
        for (int k = 1; k < n; k++) {

            currentScore += change[k];

            // Update only when a strictly better score is found
            if (currentScore > maxScore) {
                maxScore = currentScore;
                bestK = k;
            }
        }

        return bestK;
    }
}