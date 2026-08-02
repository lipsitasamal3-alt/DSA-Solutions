/*
---------------------------------------------------------
Problem: Shuffle an Array

Platform: LeetCode

Difficulty: Medium

Approach:
Fisher-Yates Shuffle

Algorithm:
1. Store a copy of the original array.
2. For reset():
   - Restore the array by cloning the original array.
   - Return the restored array.
3. For shuffle():
   - Traverse the array from left to right.
   - For each index i:
       - Randomly select an index between i and the last index.
       - Swap the elements at i and the selected index.
4. Return the shuffled array.

Time Complexity:
Reset: O(n)
Shuffle: O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/shuffle-an-array/
---------------------------------------------------------
*/

class Solution {

    private int[] original;
    private int[] array;
    private Random random;

    public Solution(int[] nums) {

        this.array = nums;
        this.original = nums.clone();
        this.random = new Random();
    }

    public int[] reset() {

        this.array = this.original.clone();
        return this.array;
    }

    public int[] shuffle() {

        for (int i = 0; i < array.length; i++) {

            int swapIndex = random.nextInt(array.length - i) + i;

            int temp = array[i];
            array[i] = array[swapIndex];
            array[swapIndex] = temp;
        }

        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */