package p0500_;

// Merge two sorted linked lists and return it as a new list.
// The new list should be made by splicing together the nodes of the first two lists.

import struct.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Puzzle021_MergeTwoSortedLists {

    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0), head = result;
            while (l1 != null || l2 != null) {
                ListNode node;
                if (l1 == null) {
                    node = new ListNode(l2.val);
                    l2 = l2.next;
                } else if (l2 == null) {
                    node = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    if (l1.val <= l2.val) {
                        node = new ListNode(l1.val);
                        l1 = l1.next;
                    } else {
                        node = new ListNode(l2.val);
                        l2 = l2.next;
                    }
                }
                result.next = node;
                result = result.next;
            }
            return head.next;
        }
    }

    public class RecursiveSolution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l2.next, l1);
                return l2;
            }
        }
    }
}
