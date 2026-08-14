/*
---------------------------------------------------------
Problem: Max Sum of Rectangle No Larger Than K

Platform: LeetCode

Difficulty: Hard

Approach:
Arrays + Prefix Sum + TreeSet

Algorithm:
1. If there are more rows than columns, transpose the
   conceptual traversal so that the smaller dimension is
   treated as rows. This reduces the complexity.

2. Fix a `left` column.

3. Expand the `right` column one step at a time and maintain
   the sum of each row between `left` and `right`.

4. Now the 2D problem becomes a 1D problem:
   Find the maximum subarray sum that is <= k.

5. Use a TreeSet to store prefix sums in sorted order.

6. For the current prefix sum:
      target >= currentPrefixSum - k

   `ceiling(currentPrefixSum - k)` gives the smallest prefix
   sum that allows the resulting subarray sum to be <= k
   while being as large as possible.

7. Track the maximum valid sum.

8. If the answer reaches exactly k, return immediately.

Time Complexity:
O(min(m,n)² × max(m,n) × log(max(m,n)))

Space Complexity:
O(min(m,n))

Link:
https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
---------------------------------------------------------
*/

class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;

        // Work with the smaller dimension as rows
        boolean transpose = m > n;

        int rows = transpose ? n : m;
        int cols = transpose ? m : n;

        for (int left = 0; left < cols; left++) {

            int[] rowSums = new int[rows];

            for (int right = left; right < cols; right++) {

                // Build row sums between left and right
                for (int r = 0; r < rows; r++) {

                    int val = transpose
                            ? matrix[right][r]
                            : matrix[r][right];

                    rowSums[r] += val;
                }

                // Find maximum subarray sum <= k
                TreeSet<Integer> sortedSums = new TreeSet<>();
                sortedSums.add(0);

                int currentPrefixSum = 0;

                for (int rowSum : rowSums) {

                    currentPrefixSum += rowSum;

                    Integer target =
                            sortedSums.ceiling(currentPrefixSum - k);

                    if (target != null) {

                        maxSum = Math.max(
                                maxSum,
                                currentPrefixSum - target
                        );

                        // Cannot do better than k
                        if (maxSum == k) {
                            return k;
                        }
                    }

                    sortedSums.add(currentPrefixSum);
                }
            }
        }

        return maxSum;
    }
}