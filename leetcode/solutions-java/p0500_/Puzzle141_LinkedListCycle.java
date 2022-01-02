/*
https://leetcode.com/problems/linked-list-cycle/description/

Given a linked list, determine if it has a cycle in it.

Follow up:
  Can you solve it without using extra space?
 */

package p0500_;

import struct.ListNode;

/**
 * @author half-dead
 */
public class Puzzle141_LinkedListCycle {

    public static void main(String[] args) {
        Puzzle141_LinkedListCycle p = new Puzzle141_LinkedListCycle();
        Solution solution = p.new Solution();
        ListNode node = new ListNode(new int[]{3, 2, 0, -4});
        node.next.next.next.next = node.next;
        boolean b = solution.hasCycle(node);
        System.out.println(b);

        Solution2 s2 = p.new Solution2();
        System.out.println(s2.hasCycle(node));
    }

    // use fast and slow pointers
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && slow != null) {
                slow = slow.next;
                if (slow == null) {
                    break;
                }

                fast = fast.next;
                if (fast == null) {
                    break;
                } else {
                    fast = fast.next;
                }

                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }

    // without fast & slow pointers
    public class Solution2 {
        public boolean hasCycle(ListNode head) {
            ListNode dummy = head;
            while (head != null) {
                ListNode temp = head.next;
                if (head.next == dummy) {
                    return true;
                }
                head.next = dummy;
                head = temp;
            }
            return false;
        }
    }
}
