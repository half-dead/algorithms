/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:
    Input: 1->2->3->3->4->4->5
    Output: 1->2->5
Example 2:
    Input: 1->1->1->2->3
    Output: 2->3
 */

package p0500_;

import struct.ListNode;

/**
 * @author half-dead
 */
public class Puzzle082_RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        Solution s = new Puzzle082_RemoveDuplicatesFromSortedListII().new Solution();
        System.out.println(s.deleteDuplicates(new ListNode(new int[]{1, 2, 2})));
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode root = new ListNode(0);
            ListNode dummy = root;
            while (head != null) {
                boolean dup = false;
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                    dup = true;
                }
                if (!dup) {
                    dummy.next = head;
                    dummy = dummy.next;
                }
                head = head.next;
            }
            dummy.next = null;
            return root.next;
        }
    }
}
