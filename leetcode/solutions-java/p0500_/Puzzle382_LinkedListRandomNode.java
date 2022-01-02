package p0500_;

import struct.ListNode;

import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 *
 * @author half-dead
 */
public class Puzzle382_LinkedListRandomNode {
    class Solution {
        ListNode[] arr;
        Random rand;

        public Solution(ListNode head) {
            int size = 0;
            ListNode node = head;
            while (node != null) {
                node = node.next;
                size++;
            }

            arr = new ListNode[size];
            int i = 0;
            while (head != null) {
                arr[i++] = head;
                head = head.next;
            }

            rand = new Random();
        }

        public int getRandom() {
            return arr[rand.nextInt(arr.length)].val;
        }
    }

}
