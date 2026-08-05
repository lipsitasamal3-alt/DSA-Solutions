/*
---------------------------------------------------------
Problem: Reach a Number

Platform: LeetCode

Difficulty: Medium

Approach:
Math (Greedy)

Algorithm:
1. Take the absolute value of the target since the problem is
   symmetric about zero.
2. Initialize:
   - k = 0 (number of moves)
   - currentSum = 0 (sum of moves)
3. Repeatedly:
   - Increment k.
   - Add k to currentSum.
4. Continue until:
   - currentSum is at least the target, and
   - (currentSum - target) is even.
5. Return k.

Explanation:
- Flipping the direction of a move changes the total position by
  twice that move's value.
- Therefore, the difference between the accumulated sum and the
  target must be even.

Time Complexity:
O(√target)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/reach-a-number/
---------------------------------------------------------
*/

class Solution {

    public int reachNumber(int target) {

        target = Math.abs(target);

        int k = 0;
        long currentSum = 0;

        while (currentSum < target || (currentSum - target) % 2 != 0) {

            k++;
            currentSum += k;
        }

        return k;
    }
}