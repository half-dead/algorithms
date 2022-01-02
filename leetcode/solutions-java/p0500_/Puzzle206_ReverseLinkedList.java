package p0500_;

// Reverse a singly linked list.
//
// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

import struct.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Puzzle206_ReverseLinkedList {

    public class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }
    }

    public class RecursiveSolution {
        public ListNode reverseList(ListNode head) {
            return swap(head, null);
        }

        public ListNode swap(ListNode head, ListNode next) {
            if (head == null)
                return next;
            ListNode node = head.next;
            head.next = next;
            return swap(node, head);
        }
    }

}
