package p2000_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/merge-in-between-linked-lists/
 *
 * @author half-dead
 */
public class Puzzle1669 {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeInBetween(ListNode list1, int from, int to, ListNode list2) {
            ListNode head2 = list2, tail2 = list2;
            ListNode nodeA = null, nodeB = null;

            while (tail2.next != null) {
                tail2 = tail2.next;
            }

            int cnt = 0;
            ListNode node = list1;
            while (cnt < to) {
                ++cnt;
                if (cnt == from) {
                    nodeA = node;
                }
                if (cnt == to) {
                    nodeB = node.next.next;
                }
                node = node.next;
            }
            nodeA.next = head2;
            tail2.next = nodeB;
            return list1;
        }
    }
}
