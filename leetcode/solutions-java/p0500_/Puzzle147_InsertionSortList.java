/*
https://leetcode.com/problems/insertion-sort-list/description/

Sort a linked list using insertion sort.

A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list


Algorithm of Insertion Sort:
    Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
    At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
    It repeats until no input elements remain.

Example 1:
    Input: 4->2->1->3
    Output: 1->2->3->4
Example 2:
    Input: -1->5->3->4->0
    Output: -1->0->3->4->5
 */

package p0500_;

import struct.ListNode;

/**
 * @author half-dead
 */
public class Puzzle147_InsertionSortList {

    public static void main(String[] args) {
        Puzzle147_InsertionSortList p = new Puzzle147_InsertionSortList();
        Solution s = p.new Solution();
        ListNode listNode = s.insertionSortList(new ListNode(new int[]{Integer.MIN_VALUE + 1, Integer.MIN_VALUE}));
        System.out.println(listNode);
    }

    // Worst case O(N^2)
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = new ListNode(Integer.MIN_VALUE);
            newHead.next = head;
            ListNode sortedTail = head;
            while (head != null) {
                ListNode node = head;
                int value = node.val;
                ListNode pos = newHead, prev = newHead;
                while (value > pos.val) {
                    prev = pos;
                    pos = pos.next;
                }
                head = head.next;
                if (pos == newHead) {
                    sortedTail.next = node.next;
                    node.next = pos.next;
                    pos.next = node;
                } else if (node != pos) {
                    prev.next = node;
                    sortedTail.next = node.next;
                    node.next = pos;
                } else {
                    sortedTail = node;
                }
            }
            return newHead.next;
        }
    }
}
