/*
https://leetcode.com/problems/add-two-numbers/

You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

package p0500_;

import struct.ListNode;

/**
 * @author half-dead
 */
public class Puzzle002_AddTwoNumbers {

    public static void main(String[] args) {
        Puzzle002_AddTwoNumbers puzzle002 = new Puzzle002_AddTwoNumbers();
//        StupidSolution solution = puzzle002.new StupidSolution();
        Solution solution = puzzle002.new Solution();
        ListNode listNode = solution.addTwoNumbers(new ListNode(new int[]{0}), new ListNode(new int[]{0}));
        System.out.println(listNode);
    }

    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum, extra = 0;
            ListNode head = null, tail = null;
            while (l1 != null || l2 != null) {
                sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + extra;
                extra = sum > 9 ? 1 : 0;

                if (head == null) {
                    head = new ListNode(sum % 10);
                    tail = head;
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (extra > 0) {
                tail.next = new ListNode(1);
            }
            return head;
        }
    }

    public class StupidSolution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            long n1 = l1.val;
            long n2 = l2.val;
            long power = 1;
            while (l1.next != null) {
                l1 = l1.next;
                power *= 10;
                n1 += l1.val * power;
            }
            power = 1;
            while (l2.next != null) {
                l2 = l2.next;
                power *= 10;
                n2 += l2.val * power;
            }
            long result = n1 + n2;
            if (result == 0) {
                return new ListNode(0);
            }
            ListNode rn = null, start = null;
            while (result > 0) {
                if (rn != null) {
                    ListNode next = new ListNode((int) (result % 10L));
                    rn.next = next;
                    rn = next;
                } else {
                    rn = new ListNode((int) (result % 10L));
                    start = rn;
                }
                result /= 10;
            }
            return start;
        }
    }

}
