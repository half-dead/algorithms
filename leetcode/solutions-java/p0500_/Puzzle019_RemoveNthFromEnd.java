package p0500_;

// Given a linked list, remove the nth node from the end of list and return its head.
//
// For example,
//
// Given linked list: 1->2->3->4->5, and n = 2.
//
// After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.


import struct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Puzzle019_RemoveNthFromEnd {

    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode start = new ListNode(0);
            ListNode fast = start, slow = start;
            slow.next = head;
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return start.next;
        }
    }

    public class StupidSolution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next == null) {
                return null;
            }
            ListNode first = head;
            int i = 0;
            List<ListNode> arr = new ArrayList<>();
            while (head != null) {
                arr.add(head);
                head = head.next;
                i++;
            }
            if (arr.size() == n) {
                return arr.get(1);
            } else if (n == 1) {
                arr.get(arr.size() - n - 1).next = null;
            } else {
                arr.get(arr.size() - n - 1).next = arr.get(arr.size() - n + 1);
            }
            return first;
        }
    }

}
