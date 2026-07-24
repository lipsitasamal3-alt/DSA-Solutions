/*
---------------------------------------------------------
Problem: Design Linked List

Platform: LeetCode

Difficulty: Medium

Approach:
Singly Linked List with Dummy Head

Algorithm:
1. Maintain:
   - A dummy head node.
   - A variable `size` to track the number of nodes.
2. For get(index):
   - Return -1 if the index is invalid.
   - Traverse to the required node and return its value.
3. For addAtHead(val):
   - Insert a new node at index 0.
4. For addAtTail(val):
   - Insert a new node at index `size`.
5. For addAtIndex(index, val):
   - Ignore the operation if index > size.
   - If index < 0, treat it as 0.
   - Traverse to the node before the insertion point.
   - Insert the new node and increment size.
6. For deleteAtIndex(index):
   - Ignore the operation if the index is invalid.
   - Traverse to the node before the target node.
   - Remove the target node and decrement size.

Time Complexity:
Get: O(n)
AddAtHead: O(1)
AddAtTail: O(n)
AddAtIndex: O(n)
DeleteAtIndex: O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/design-linked-list/
---------------------------------------------------------
*/

class MyLinkedList {

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private final ListNode dummy;
    private int size;

    public MyLinkedList() {

        dummy = new ListNode(0);
        size = 0;
    }

    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode current = dummy.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    public void addAtHead(int val) {

        addAtIndex(0, val);
    }

    public void addAtTail(int val) {

        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        ListNode previous = dummy;

        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = previous.next;
        previous.next = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        ListNode previous = dummy;

        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }

        previous.next = previous.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index, val);
 * obj.deleteAtIndex(index);
 */