package p0500_;

// Write a program to find the node at which the intersection of two singly linked lists begins.
//
// For example, the following two linked lists:
// A:          a1 → a2
//                    ↘
//                     c1 → c2 → c3
//                    ↗
// B:     b1 → b2 → b3
// begin to intersect at node c1.
//
// Notes:
//   If the two linked lists have no intersection at all, return null.
//   The linked lists must retain their original structure after the function returns.
//   You may assume there are no cycles anywhere in the entire linked structure.
//   Your code should preferably run in O(n) time and use only O(1) memory.

import struct.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Puzzle160_IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        Puzzle160_IntersectionOfTwoLinkedLists p = new Puzzle160_IntersectionOfTwoLinkedLists();
        AwesomeSolution solution = p.new AwesomeSolution();
        solution.getIntersectionNode(new ListNode(new int[]{1, 2, 5}), new ListNode(new int[]{3, 4}));
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA, b = headB;
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            ListNode longerTail = headA != null ? headA : headB;
            ListNode longerHead = headA != null ? a : b;
            ListNode shorterHead = headA == null ? a : b;
            while (longerTail != null) {
                longerTail = longerTail.next;
                longerHead = longerHead.next;
            }
            while (longerHead != null && shorterHead != null) {
                if (longerHead == shorterHead) {
                    return longerHead;
                }
                longerHead = longerHead.next;
                shorterHead = shorterHead.next;
            }
            return null;
        }
    }


    public class AwesomeSolution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pa = headA, pb = headB;
            while (pa != pb) {
                pa = pa == null ? headB : pa.next;
                pb = pb == null ? headA : pb.next;
            }
            return pa;
        }
    }
}
