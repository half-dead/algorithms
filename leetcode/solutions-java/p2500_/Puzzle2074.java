package p2500_;

import struct.ListNode;

/**
 * @author half-dead
 */
public class Puzzle2074 {

    public static void main(String[] args) {
        Solution s = new Puzzle2074().new Solution();
        System.out.println(s.reverseEvenLengthGroups(new ListNode(new int[]{5, 2, 6, 3, 9, 1, 7, 3, 8, 4})));
    }

    // O(N) time, O(1) space
    class Solution {
        public ListNode reverseEvenLengthGroups(ListNode head) {
            int group = 1, curr = 0;
            ListNode node = head, left = head;

            while (node != null) {
                curr++;

                if (curr == group || node.next == null) {
                    if (curr % 2 == 0) {
                        ListNode groupHead = left.next, groupTail = node, right = node.next;
                        ListNode temp = groupHead, next = temp.next;
                        while (curr-- > 1) {
                            ListNode tempnext = next.next;
                            next.next = temp;
                            temp = next;
                            next = tempnext;
                        }
                        left.next = groupTail;
                        groupHead.next = right;
                        node = groupHead;
                    }
                    left = node;
                    group++;
                    curr = 0;
                }

                node = node.next;
            }
            return head;
        }
    }
}
