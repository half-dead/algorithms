package p2500_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/merge-nodes-in-between-zeros/
 *
 * @author half-dead
 */
public class Puzzle2181 {
    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode curr = dummy;
            int sum = 0;
            while (head != null) {
                if (head.val == 0) {
                    ListNode temp = head.next != null ? new ListNode() : null;
                    curr.val = sum;
                    sum = 0;
                    curr.next = temp;
                    curr = curr.next;
                } else {
                    sum += head.val;
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
}
