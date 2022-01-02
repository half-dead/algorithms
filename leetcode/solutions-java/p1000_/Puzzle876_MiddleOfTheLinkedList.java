package p1000_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @author half-dead
 */
public class Puzzle876_MiddleOfTheLinkedList {
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (slow != null && fast != null) {
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                    slow = slow.next;
                } else {
                    break;
                }
            }
            return slow;
        }
    }
}
