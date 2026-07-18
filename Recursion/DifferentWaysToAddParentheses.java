/*
---------------------------------------------------------
Problem: Different Ways to Add Parentheses

Platform: LeetCode

Difficulty: Medium

Approach:
Recursion + Memoization

Algorithm:
1. If the current expression is already computed,
   return the stored result.
2. Traverse the expression character by character.
3. Whenever an operator is found:
   - Split the expression into left and right parts.
   - Recursively compute all possible results for
     both parts.
   - Combine every left result with every right result
     using the current operator.
4. If no operator exists, convert the expression into
   an integer.
5. Store the computed result in the memo map.
6. Return the list of all possible results.

Time Complexity:
Approximately O(n · Catalan(n))
(Memoization avoids repeated computations.)

Space Complexity:
O(n²)
(Memoization + recursion stack.)

Link:
https://leetcode.com/problems/different-ways-to-add-parentheses/
---------------------------------------------------------
*/

class Solution {

    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {

        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();
        boolean hasOperator = false;

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {

                hasOperator = true;

                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                for (int left : leftResults) {
                    for (int right : rightResults) {

                        if (ch == '+') {
                            results.add(left + right);
                        } else if (ch == '-') {
                            results.add(left - right);
                        } else {
                            results.add(left * right);
                        }
                    }
                }
            }
        }

        if (!hasOperator) {
            results.add(Integer.parseInt(expression));
        }

        memo.put(expression, results);

        return results;
    }
}