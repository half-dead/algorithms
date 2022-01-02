/*
https://leetcode.com/problems/linked-list-cycle-ii/description/

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Note: Do not modify the linked list.

Follow up:
    Can you solve it without using extra space?


 */

package p0500_;

import struct.ListNode;

/**
 * @author half-dead
 */
public class Puzzle142_LinkedListCycleII {

    public static void main(String[] args) {
        Solution s = new Puzzle142_LinkedListCycleII().new Solution();
        ListNode head = new ListNode(new int[]{3, 2, 0, -4});
        head.next.next.next.next = head.next;
        System.out.println(s.detectCycle(head).val);

        ListNode head2 = new ListNode(new int[]{1, 2});
        head2.next.next = head2;
        System.out.println(s.detectCycle(head2).val);
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (slow != null && fast != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                    if (slow == fast) {
                        break;
                    }
                }
            }
            if (slow == null || fast == null) {
                return null;
            }
            while (head != fast) {
                head = head.next;
                fast = fast.next;
            }
            return head;
        }
    }
}
