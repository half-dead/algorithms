/*
https://leetcode.com/problems/delete-node-in-a-linked-list/description/

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
the linked list should become 1 -> 2 -> 4 after calling your function.
 */

package p0500_;

import struct.ListNode;

/**
 * @author half-dead
 */
public class Puzzle237_DeleteNodeInALinkedList {

    class Solution {
        public void deleteNode(ListNode node) {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        }
    }
}
