/*
---------------------------------------------------------
Problem: The kth Factor of n

Platform: LeetCode

Difficulty: Medium

Approach:
Math + Factors

Algorithm:
1. Iterate from 1 to √n.
2. Whenever `i` divides `n`:
   - `i` is a factor.
   - Count it.
   - If it is the kth factor, return it.
3. The corresponding factor `n / i` is also a factor.
   Store it separately because it appears in reverse order.
4. After checking all factors up to √n:
   - If k is within the remaining large factors, retrieve
     the appropriate factor from the stored list.
5. If fewer than k factors exist, return -1.

Why √n?
Factors occur in pairs:
    i × (n / i) = n

So finding one factor automatically gives us its pair.

Time Complexity:
O(√n)

Space Complexity:
O(√n)

Link:
https://leetcode.com/problems/the-kth-factor-of-n/
---------------------------------------------------------
*/

class Solution {

    public int kthFactor(int n, int k) {

        List<Integer> largeFactors = new ArrayList<>();

        int count = 0;

        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {

                count++;

                // Small factor
                if (count == k) {
                    return i;
                }

                // Corresponding large factor
                if (i * i != n) {
                    largeFactors.add(n / i);
                }
            }
        }

        int largeFactorsSize = largeFactors.size();

        if (k <= count + largeFactorsSize) {

            return largeFactors.get(
                largeFactorsSize - (k - count)
            );
        }

        return -1;
    }
}