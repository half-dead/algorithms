package p1000_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/linked-list-components/
 *
 * @author half-dead
 */
public class Puzzle817_LinkedListComponents {
    class Solution {
        public int numComponents(ListNode head, int[] g) {
            ListNode node = head;
            int count = 0;
            while (node != null) {
                node = node.next;
                count++;
            }

            boolean[] marker = new boolean[count];
            for (int val : g) {
                marker[val] = true;
            }

            int result = 0;
            while (head != null) {
                while (head != null && !marker[head.val]) {
                    head = head.next;
                }
                if (head != null) {
                    result++;
                }
                while (head != null && marker[head.val]) {
                    head = head.next;
                }
            }
            return result;
        }
    }
}
