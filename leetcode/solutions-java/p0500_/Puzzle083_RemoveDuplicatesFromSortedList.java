package p0500_;

// Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

import struct.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Puzzle083_RemoveDuplicatesFromSortedList {

    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode first = head;
            while (head != null) {
                while (head.next != null && head.val == head.next.val) {
                    head.next = head.next.next;
                }
                head = head.next;
            }
            return first;
        }
    }

}
