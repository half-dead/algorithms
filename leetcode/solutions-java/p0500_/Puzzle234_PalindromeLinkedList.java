/*
 https://leetcode.com/problems/palindrome-linked-list/

 Given a singly linked list, determine if it is a palindrome.
 For example:
 1 -> 2 -> 3 -> 4 is not a palindrome
 1 -> 2 -> 3 -> 2 -> 1 is a palindrome

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */

package p0500_;

import struct.ListNode;

public class Puzzle234_PalindromeLinkedList {

    public static void main(String[] args) {
        Puzzle234_PalindromeLinkedList p = new Puzzle234_PalindromeLinkedList();
        Solution s1 = p.new Solution();
        System.out.println(s1.isPalindrome(new ListNode(new int[]{1, 2, 1, 3, 1, 2, 1})));
    }

    public class Solution {
        public boolean isPalindrome(ListNode head) {
            int length = 0;
            ListNode temp = head;
            while (temp != null) {
                temp = temp.next;
                length++;
            }

            if (length < 2) {
                return true;
            }

            ListNode leftHead = head, rightHead = head, node = head;

            ListNode dummy = null;
            for (int i = 0; i < length / 2; i++) {
                rightHead = rightHead.next;
                node = leftHead.next;
                leftHead.next = dummy;
                dummy = leftHead;
                if (i < (length / 2 - 1)) {
                    leftHead = node;
                }
            }

            if (length % 2 != 0) {
                rightHead = rightHead.next;
            }

            while (leftHead.val == rightHead.val) {
                if (leftHead.next == null) {
                    return true;
                }
                leftHead = leftHead.next;
                rightHead = rightHead.next;
            }
            return false;
        }
    }

}
