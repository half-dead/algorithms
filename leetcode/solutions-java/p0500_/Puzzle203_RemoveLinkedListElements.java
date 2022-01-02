package p0500_;

// Remove all elements from a linked list of integers that have value val.
//
// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5

import struct.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class Puzzle203_RemoveLinkedListElements {
    public static void main(String[] args) {
        Puzzle203_RemoveLinkedListElements p = new Puzzle203_RemoveLinkedListElements();
        Solution solution = p.new Solution();
        ListNode listNode = solution.removeElements(new ListNode(new int[]{2, 1, 3, 1, 5, 1, 1, 1, 1}), 1);
        System.out.println(listNode);
    }

    public class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode p = new ListNode(val + 1), guard = p;
            p.next = head;
            while (p.next != null) {
                ListNode node = p.next;
                while (node != null && node.val == val) {
                    node = node.next;
                }
                p.next = node;
                if (node == null) {
                    break;
                }
                p = p.next;
            }
            return guard.next;
        }
    }
}
