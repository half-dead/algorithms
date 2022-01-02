/*
https://leetcode.com/problems/reorder-list/description/

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:
    Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:
    Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

package p0500_;

import struct.ListNode;

/**
 * @author half-dead
 */
public class Puzzle143_ReorderList {


    class Solution {
        public void reorderList(ListNode head) {
            ListNode origin = head;
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }
            if (count < 3) {
                return;
            }

            int half = (count + 1) / 2;
            head = origin;
            while (half > 0) {
                half--;
                if (half == 0) {
                    ListNode next = head.next;
                    head.next = null;
                    head = next;
                    break;
                } else {
                    head = head.next;
                }
            }
            ListNode rightHead = head, dummy = null;
            while (rightHead != null) {
                ListNode next = rightHead.next;
                rightHead.next = dummy;
                dummy = rightHead;
                if (next != null) {
                    rightHead = next;
                } else {
                    break;
                }
            }
            ListNode leftHead = origin;
            while (leftHead != null) {
                ListNode ln = leftHead.next;
                ListNode rn = null;
                if (rightHead != null) {
                    rn = rightHead.next;
                }
                if (rightHead != null) {
                    leftHead.next = rightHead;
                    rightHead.next = ln;
                }
                leftHead = ln;
                rightHead = rn;
            }
        }
    }
}
