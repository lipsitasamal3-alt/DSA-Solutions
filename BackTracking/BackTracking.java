/*
---------------------------------------------------------
Problem: Combination Sum

Platform: LeetCode

Difficulty: Medium

Approach:
Backtracking

Algorithm:
1. Create a result list to store all valid combinations.
2. Use recursion to explore possible choices.
3. At each step:
   - Add the current candidate to the combination.
   - Reduce the remaining target.
   - Continue searching from the same index to allow reuse
     of the same number.
4. If the remaining target becomes 0:
   - Add the current combination to the result.
5. If the remaining target becomes negative:
   - Stop exploring that path.
6. Backtrack by removing the last added element and try
   the next possibility.

Time Complexity:
O(N^(T/M))

Space Complexity:
O(T/M)

Where:
N = Number of candidates
T = Target value
M = Minimum candidate value

Link:
https://leetcode.com/problems/combination-sum/
---------------------------------------------------------
*/

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();

        backtrack(candidates, target, new ArrayList<>(), 0, results);

        return results;
    }

    private void backtrack(int[] candidates, int remain,
                           List<Integer> combat, int start,
                           List<List<Integer>> results) {

        if (remain == 0) {

            results.add(new ArrayList<>(combat));
            return;

        } else if (remain < 0) {

            return;
        }

        for (int i = start; i < candidates.length; i++) {

            combat.add(candidates[i]);

            backtrack(candidates, remain - candidates[i],
                      combat, i, results);

            combat.remove(combat.size() - 1);
        }
    }
}