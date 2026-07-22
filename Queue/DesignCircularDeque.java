/*
---------------------------------------------------------
Problem: Design Circular Deque

Platform: LeetCode

Difficulty: Medium

Approach:
Array Simulation (Circular Deque)

Algorithm:
1. Initialize:
   - An array of size k.
   - front and rear pointers.
   - size to track the number of elements.
   - capacity as the maximum size.
2. For insertFront(value):
   - If the deque is full, return false.
   - Move the front pointer backward circularly.
   - Insert the value and increment size.
3. For insertLast(value):
   - If the deque is full, return false.
   - Insert the value at the rear.
   - Move the rear pointer forward circularly.
   - Increment size.
4. For deleteFront():
   - If the deque is empty, return false.
   - Move the front pointer forward circularly.
   - Decrement size.
5. For deleteLast():
   - If the deque is empty, return false.
   - Move the rear pointer backward circularly.
   - Decrement size.
6. For getFront() and getRear():
   - Return the corresponding element if the deque is not empty.
7. For isEmpty() and isFull():
   - Check whether size is 0 or equal to capacity.

Time Complexity:
InsertFront: O(1)
InsertLast: O(1)
DeleteFront: O(1)
DeleteLast: O(1)
GetFront: O(1)
GetRear: O(1)
isEmpty: O(1)
isFull: O(1)

Space Complexity:
O(k)

Link:
https://leetcode.com/problems/design-circular-deque/
---------------------------------------------------------
*/

class MyCircularDeque {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {

        capacity = k;
        queue = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        front = (front - 1 + capacity) % capacity;
        queue[front] = value;
        size++;

        return true;
    }

    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }

        queue[rear] = value;
        rear = (rear + 1) % capacity;
        size++;

        return true;
    }

    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        rear = (rear - 1 + capacity) % capacity;
        size--;

        return true;
    }

    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        return queue[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */