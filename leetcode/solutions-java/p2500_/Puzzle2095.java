package p2500_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 *
 * @author half-dead
 */
public class Puzzle2095 {

    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode slow = head, fast = head, prev = dummy;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = slow.next;
            return dummy.next;
        }
    }
}
