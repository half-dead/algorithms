/*
https://leetcode.com/problems/add-two-numbers-ii/description/

You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
    What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
Example:
    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 8 -> 0 -> 7
 */

package p0500_;

import struct.ListNode;

import java.math.BigInteger;

/**
 * @author half-dead
 */
public class Puzzle445_AddTwoNumbersII {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            StringBuilder a = new StringBuilder();
            while (l1 != null) {
                a.append(l1.val);
                l1 = l1.next;
            }
            StringBuilder b = new StringBuilder();
            while (l2 != null) {
                b.append(l2.val);
                l2 = l2.next;
            }
            String result = String.valueOf(new BigInteger(a.toString()).add(new BigInteger(b.toString())));
            char[] chars = result.toCharArray();
            ListNode node = new ListNode(0);
            ListNode head = node;
            for (int i = 0; i < chars.length; i++) {
                node.val = chars[i] - '0';
                if (i < chars.length - 1) {
                    node.next = new ListNode(0);
                    node = node.next;
                }
            }
            return head;
        }
    }
}
