package p2500_;

import struct.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 *
 * @author half-dead
 */
public class Puzzle2130 {

    // no need to reverse half of the input, O(N) time & space
    class Solution {
        public int pairSum(ListNode head) {
            LinkedList<Integer> stack = new LinkedList<>();
            ListNode slow = head, fast = head;
            while (fast != null) {
                fast = fast.next.next;
                stack.push(slow.val);
                slow = slow.next;
            }
            int res = 0;
            while (slow != null) {
                res = Math.max(res, stack.pop() + slow.val);
                slow = slow.next;
            }
            return res;
        }
    }
}
