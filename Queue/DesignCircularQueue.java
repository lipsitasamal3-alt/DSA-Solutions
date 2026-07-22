/*
---------------------------------------------------------
Problem: Design Circular Queue

Platform: LeetCode

Difficulty: Medium

Approach:
Array Simulation (Circular Queue)

Algorithm:
1. Initialize:
   - An array of size k.
   - head pointer to the front.
   - size to track the number of elements.
   - maxSize as the queue capacity.
2. For enQueue(value):
   - If the queue is full, return false.
   - Compute the tail index using:
     (head + size) % maxSize.
   - Insert the value and increment size.
3. For deQueue():
   - If the queue is empty, return false.
   - Move the head pointer circularly.
   - Decrement size.
4. For Front():
   - Return the front element if the queue is not empty.
5. For Rear():
   - Return the last element using:
     (head + size - 1) % maxSize.
6. For isEmpty() and isFull():
   - Check whether size is 0 or equal to maxSize.

Time Complexity:
EnQueue: O(1)
DeQueue: O(1)
Front: O(1)
Rear: O(1)
isEmpty: O(1)
isFull: O(1)

Space Complexity:
O(k)

Link:
https://leetcode.com/problems/design-circular-queue/
---------------------------------------------------------
*/

class MyCircularQueue {

    private int[] queue;
    private int head;
    private int size;
    private int maxSize;

    public MyCircularQueue(int k) {

        queue = new int[k];
        maxSize = k;
        head = 0;
        size = 0;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        int tail = (head + size) % maxSize;
        queue[tail] = value;
        size++;

        return true;
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % maxSize;
        size--;

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[head];
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        int tail = (head + size - 1) % maxSize;
        return queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */