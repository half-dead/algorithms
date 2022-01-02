/*
https://leetcode.com/problems/partition-list/description/

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example:
    Input: head = 1->4->3->2->5->2, x = 3
    Output: 1->2->2->4->3->5
 */

package p0500_;

import struct.ListNode;

/**
 * @author half-dead
 */
public class Puzzle086_PartitionList {

    public static void main(String[] args) {
        Solution s = new Puzzle086_PartitionList().new Solution();
        System.out.println(s.partition(new ListNode(new int[]{1, 1}), 0));
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode leftHead = null, rightHead = null;
            ListNode dummyLeft = null, dummyRight = null;

            while (head != null) {
                if (head.val >= x) {
                    if (rightHead == null) {
                        rightHead = head;
                        dummyRight = rightHead;
                    } else {
                        rightHead.next = head;
                        rightHead = rightHead.next;
                    }
                } else {
                    if (leftHead == null) {
                        leftHead = head;
                        dummyLeft = leftHead;
                    } else {
                        leftHead.next = head;
                        leftHead = leftHead.next;
                    }
                }
                head = head.next;
            }
            if (rightHead != null) {
                rightHead.next = null;
            }
            if (leftHead != null) {
                leftHead.next = dummyRight;
            } else {
                dummyLeft = dummyRight;
            }
            return dummyLeft;
        }
    }
}
