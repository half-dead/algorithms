package p0500_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * @author half-dead
 */
public class Puzzle328_OddEvenLinkedList {
    public static void main(String[] args) {
        Puzzle328_OddEvenLinkedList p = new Puzzle328_OddEvenLinkedList();
        Solution s = p.new Solution();
        ListNode listNode = s.oddEvenList(new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(listNode);
    }

    class Solution {
        public ListNode oddEvenList(ListNode node) {
            if (node == null) return null;
            ListNode odd = node, even = node.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return node;
        }
    }


    class Solution2 {
        public ListNode oddEvenList(ListNode node) {
            ListNode dummyOdd = new ListNode(0), dummyEven = new ListNode(0);
            ListNode oddHead = dummyOdd, evenHead = dummyEven;
            boolean odd = true;
            while (node != null) {
                ListNode next = node.next;
                if (odd) {
                    oddHead.next = node;
                    oddHead = oddHead.next;
                    odd = false;
                } else {
                    evenHead.next = node;
                    evenHead = evenHead.next;
                    odd = true;
                }
                node = next;
            }
            evenHead.next = null;
            oddHead.next = dummyEven.next;
            return dummyOdd.next;
        }
    }
}
