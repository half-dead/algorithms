/*
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

package p0500_;

import struct.ListNode;
import struct.TreeNode;

/**
 * @author half-dead
 */
public class Puzzle109_ConvertSortedListToBinarySearchTree {

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return new TreeNode(head.val);
            }
            int count = 0;
            ListNode origin = head;
            while (head != null) {
                count++;
                head = head.next;
            }
            int half = count / 2;
            head = origin;
            ListNode mid = null, rightHead = null;
            while (half > 0) {
                half--;
                if (half == 0) {
                    mid = head.next;
                    if (mid != null) {
                        rightHead = mid.next;
                    }
                    head.next = null;
                } else {
                    head = head.next;
                }
            }
            TreeNode root = new TreeNode(mid.val);
            root.left = sortedListToBST(origin);
            root.right = sortedListToBST(rightHead);
            return root;
        }
    }

    class NeatSolution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null)
                return null;
            return toBST(head, null);
        }

        public TreeNode toBST(ListNode head, ListNode tail) {
            ListNode slow = head;
            ListNode fast = head;
            if (head == tail)
                return null;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            TreeNode node = new TreeNode(slow.val);
            node.left = toBST(head, slow);
            node.right = toBST(slow.next, tail);
            return node;
        }
    }
}
