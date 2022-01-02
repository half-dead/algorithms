/*
https://leetcode.com/problems/copy-list-with-random-pointer/description/

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */

package p0500_;

import struct.RandomListNode;

/**
 * @author half-dead
 */
public class Puzzle138_CopyListWithRandomPointer {
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) {
                return null;
            }
            RandomListNode newHead = new RandomListNode(head.label);
            RandomListNode root = newHead;
            while (head.next != null) {
                newHead.next = new RandomListNode(head.next.label);
                if (head.random != null) {
                    newHead.random = new RandomListNode(head.random.label);
                }
                newHead = newHead.next;
                head = head.next;
            }
            if (head.random != null) {
                newHead.random = new RandomListNode(head.random.label);
            }
            return root;
        }
    }

    // Genius solution, damn smart
    public class Solution2 {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) {
                return null;
            }
            RandomListNode p = head;
            while (p != null) {
                RandomListNode copyNode = new RandomListNode(p.label);
                copyNode.next = p.next;
                p.next = copyNode;
                p = p.next.next;
            }
            p = head;
            while (p != null) {
                if (p.random != null) {
                    p.next.random = p.random.next;
                }
                p = p.next.next;
            }
            RandomListNode head2 = head.next, q = head2;
            p = head;
            while (p != null) {
                p.next = p.next.next;
                if (q.next == null) {
                    break;
                }
                q.next = q.next.next;
                p = p.next;
                q = q.next;
            }
            return head2;
        }
    }
}
