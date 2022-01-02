package p1500_;

import struct.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 *
 * @author half-dead
 */
public class Puzzle1171 {
    public static void main(String[] args) {
        Solution s = new Puzzle1171().new Solution();
        System.out.println(s.removeZeroSumSublists(new ListNode(new int[]{1, 2, 3, -3, -2})));
    }

    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            int sum = 0;
            ListNode dummy = new ListNode(0, head);
            Map<Integer, ListNode> seen = new HashMap<>();
            seen.put(0, dummy);
            for (ListNode n = dummy; n != null; n = n.next) seen.put((sum += n.val), n);

            sum = 0;
            for (ListNode n = dummy; n != null; n = n.next) n.next = seen.get((sum += n.val)).next;
            return dummy.next;
        }
    }


    class MySolution {
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            int sum = 0;
            Map<Integer, ListNode> seen = new HashMap<>();
            seen.put(sum, dummy);
            LinkedList<Integer> stack = new LinkedList<>();
            stack.push(sum);
            while (head != null) {
                sum += head.val;
                ListNode prev = seen.get(sum);
                if (prev != null) {
                    while (stack.peek() != sum) {
                        seen.remove(stack.pop());
                    }
                    prev.next = head.next;
                } else {
                    seen.put(sum, head);
                    stack.push(sum);
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
}
