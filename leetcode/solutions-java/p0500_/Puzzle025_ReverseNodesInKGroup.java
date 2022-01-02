package p0500_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * @author half-dead
 */
public class Puzzle025_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Puzzle025_ReverseNodesInKGroup p = new Puzzle025_ReverseNodesInKGroup();
        Solution s = p.new Solution();
        System.out.println(s.reverseKGroup(new ListNode(new int[]{1, 2}), 2));
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k <= 1 || head == null || head.next == null) return head;

            ListNode dummy = new ListNode(0), node = dummy, partHead = dummy;
            dummy.next = head;
            int i = 0;
            while (head != null) {
                if (i++ == 0) {
                    partHead = head;
                }
                head = head.next;
                if (i == k) {
                    ListNode n1 = partHead, n2 = partHead.next;
                    while (i-- > 1) {
                        ListNode temp = n2.next;
                        n2.next = n1;
                        n1 = n2;
                        n2 = temp;
                    }
                    partHead.next = null;
                    node.next = n1;
                    node = partHead;
                    i = 0;
                }
            }
            if (node != partHead) {
                node.next = partHead;
            }
            return dummy.next;
        }
    }
}
