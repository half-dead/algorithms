package p2000_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 *
 * @author half-dead
 */
public class Puzzle1721 {

    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode node = head;
            while (k > 1) {
                node = node.next;
                k--;
            }

            ListNode front = node, back = head;
            while (node.next != null) {
                node = node.next;
                back = back.next;
            }

            int temp = front.val;
            front.val = back.val;
            back.val = temp;

            return head;
        }
    }

    // swap the node itself, not only the val.
    class Solution1 {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            int index = 1;
            ListNode temp = dummy;
            while (index < k) {
                temp = temp.next;
                index++;
            }

            ListNode pofk = temp, pobk = dummy;
            temp = temp.next;
            while (temp.next != null) {
                temp = temp.next;
                pobk = pobk.next;
            }

            ListNode fk = pofk.next, bk = pobk.next;
            if (fk == bk) {
                // do nothing
            } else if (fk.next == bk) {
                pofk.next = bk;
                fk.next = bk.next;
                bk.next = fk;
            } else if (bk.next == fk) {
                pobk.next = fk;
                bk.next = fk.next;
                fk.next = bk;
            } else {
                pofk.next = bk;
                pobk.next = fk;
                ListNode ln = bk.next;
                bk.next = fk.next;
                fk.next = ln;
            }

            return dummy.next;
        }
    }
}
