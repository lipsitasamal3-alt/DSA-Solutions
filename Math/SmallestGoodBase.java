/*
---------------------------------------------------------
Problem: Smallest Good Base

Platform: LeetCode

Difficulty: Hard

Approach:
Math + Binary Search / Base Representation

Algorithm:
1. Convert the given string `n` into a long integer.

2. Find the maximum possible number of powers `m`.
   This occurs when the base is 2.

3. Try every possible `m` from the largest value down to 2.

4. For each `m`, estimate the possible base `k` using:
   k = n^(1/m)

5. If `k >= 2`, calculate:
   1 + k + k² + ... + k^m

6. Use overflow-safe multiplication while calculating
   the powers.

7. If the sum is exactly equal to `n`, then `k` is a
   valid base. Since we are checking larger `m` first,
   the first valid base found is the smallest good base.

8. If no valid base is found, the answer is `n - 1`,
   because:
   n = (n - 1) + 1
   which represents `11` in base `n - 1`.

Time Complexity:
O(log²(n))

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/smallest-good-base/
---------------------------------------------------------
*/

class Solution {

    public String smallestGoodBase(String n) {

        long num = Long.parseLong(n);

        // Maximum number of powers possible when base = 2
        int maxM = (int) (Math.log(num) / Math.log(2));

        // Try larger number of powers first
        for (int m = maxM; m >= 2; m--) {

            // Estimate the possible base
            long k = (long) Math.pow(num, 1.0 / m);

            if (k >= 2) {

                long sum = 0;
                long currentWeight = 1;
                boolean isValid = true;

                // Calculate 1 + k + k² + ... + k^m
                for (int i = 0; i <= m; i++) {

                    sum += currentWeight;

                    if (i < m) {

                        // Prevent overflow before multiplication
                        if (currentWeight > num / k) {
                            isValid = false;
                            break;
                        }

                        currentWeight *= k;
                    }
                }

                // Check if this base represents num
                if (isValid && sum == num) {
                    return String.valueOf(k);
                }
            }
        }

        // Every number has "11" representation in base num - 1
        return String.valueOf(num - 1);
    }
}