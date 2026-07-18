/*
---------------------------------------------------------
Problem: Combination Sum II

Platform: LeetCode

Difficulty: Medium

Approach:
Backtracking

Algorithm:
1. Sort the input array to group duplicate values.
2. Start backtracking from index 0.
3. If the remaining target becomes 0:
   - Add the current combination to the result.
4. Iterate through the remaining candidates:
   - Skip duplicate values at the same recursion level.
   - Stop if the current value exceeds the remaining target.
   - Include the current value in the combination.
   - Recur with:
     - Updated target.
     - Next index (each element can be used only once).
   - Backtrack by removing the last added value.
5. Return all unique combinations.

Time Complexity:
O(2ⁿ) (Worst Case)

Space Complexity:
O(n)
(Recursion stack + current combination)

Link:
https://leetcode.com/problems/combination-sum-ii/
---------------------------------------------------------
*/

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(results, new ArrayList<>(), candidates, target, 0);

        return results;
    }

    private void backtrack(List<List<Integer>> results,
                           List<Integer> currentPath,
                           int[] candidates,
                           int target,
                           int start) {

        if (target == 0) {
            results.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            currentPath.add(candidates[i]);

            backtrack(results,
                      currentPath,
                      candidates,
                      target - candidates[i],
                      i + 1);

            currentPath.remove(currentPath.size() - 1);
        }
    }
}