/*
---------------------------------------------------------
Problem: Design Skiplist

Platform: LeetCode

Difficulty: Hard

Approach:
Skip List

Algorithm:
1. Maintain:
   - A head node with the maximum number of levels.
   - The current highest level in the skip list.
   - Randomized level generation for new nodes.
2. For search(target):
   - Start from the highest level.
   - Move forward while the next node's value is smaller than the target.
   - Move down one level when no further movement is possible.
   - Check the node at level 0.
3. For add(num):
   - Record the last visited node at each level.
   - Generate a random level for the new node.
   - Increase the current level if necessary.
   - Insert the new node into all of its assigned levels.
4. For erase(num):
   - Record the last visited node at each level.
   - If the target node does not exist, return false.
   - Remove the node from every level where it appears.
   - Decrease the current level if upper levels become empty.
5. Return the appropriate result for each operation.

Time Complexity:
Search: O(log n) (Average)
Add: O(log n) (Average)
Erase: O(log n) (Average)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/design-skiplist/
---------------------------------------------------------
*/

class Skiplist {

    private static class Node {

        int val;
        Node[] next;

        Node(int val, int levels) {
            this.val = val;
            this.next = new Node[levels];
        }
    }

    private static final int MAX_LEVELS = 16;

    private final Node head;
    private int currentLevel;
    private final Random random;

    public Skiplist() {

        head = new Node(-1, MAX_LEVELS);
        currentLevel = 1;
        random = new Random();
    }

    private int randomLevel() {

        int level = 1;

        while (random.nextDouble() < 0.5 && level < MAX_LEVELS) {
            level++;
        }

        return level;
    }

    public boolean search(int target) {

        Node current = head;

        for (int level = currentLevel - 1; level >= 0; level--) {

            while (current.next[level] != null &&
                   current.next[level].val < target) {

                current = current.next[level];
            }
        }

        current = current.next[0];

        return current != null && current.val == target;
    }

    public void add(int num) {

        Node[] update = new Node[MAX_LEVELS];
        Node current = head;

        for (int level = currentLevel - 1; level >= 0; level--) {

            while (current.next[level] != null &&
                   current.next[level].val < num) {

                current = current.next[level];
            }

            update[level] = current;
        }

        int level = randomLevel();

        if (level > currentLevel) {

            for (int i = currentLevel; i < level; i++) {
                update[i] = head;
            }

            currentLevel = level;
        }

        Node newNode = new Node(num, level);

        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public boolean erase(int num) {

        Node[] update = new Node[MAX_LEVELS];
        Node current = head;

        for (int level = currentLevel - 1; level >= 0; level--) {

            while (current.next[level] != null &&
                   current.next[level].val < num) {

                current = current.next[level];
            }

            update[level] = current;
        }

        current = current.next[0];

        if (current == null || current.val != num) {
            return false;
        }

        for (int level = 0; level < currentLevel; level++) {

            if (update[level].next[level] != current) {
                break;
            }

            update[level].next[level] = current.next[level];
        }

        while (currentLevel > 1 &&
               head.next[currentLevel - 1] == null) {

            currentLevel--;
        }

        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */