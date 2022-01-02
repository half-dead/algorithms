package p0500_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * @author half-dead
 */
public class Puzzle092_ReverseLinkedListII {

    public static void main(String[] args) {
        Solution s = new Puzzle092_ReverseLinkedListII().new Solution();
        ListNode result = s.reverseBetween(new ListNode(new int[]{3, 5}), 1, 2);
        System.out.println(result);
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int start, int end) {
            int len = end - start + 1;
            if (head == null || len < 2) {
                return head;
            }

            ListNode leftHead = null, leftTail = null, middleHead = null, middleTail = null, rightHead = null;
            while (head != null) {
                ListNode next = head.next;
                if (start == 1) {
                    if (middleTail == null) {
                        middleTail = head;
                        middleHead = middleTail;
                    } else {
                        head.next = middleHead;
                        middleHead = head;
                    }
                    len--;
                    if (len == 0) {
                        start = -1;
                    }
                } else if (start > 1) {
                    if (leftHead == null) {
                        leftHead = head;
                    }
                    leftTail = head;
                    start--;
                } else {
                    if (rightHead == null) {
                        rightHead = head;
                    } else {
                        break;
                    }
                }
                head = next;
            }

            if (leftTail != null) {
                leftTail.next = middleHead;
            }
            if (middleTail != null) {
                middleTail.next = rightHead;
            }
            if (leftHead == null) {
                leftHead = middleHead;
            }
            return leftHead;
        }
    }

    class SimpleSolution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy;
            for (int i = 0; i < m - 1; i++) {
                prev = prev.next;
            }
            ListNode start = prev.next;
            ListNode then = start.next;

            for (int i = 0; i < n - m; i++) {
                start.next = then.next;
                then.next = prev.next;
                prev.next = then;
                then = start.next;
            }

            return dummy.next;
        }
    }
}
