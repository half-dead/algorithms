package p1500_;

import struct.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 *
 * @author half-dead
 */
public class Puzzle1019 {

    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            int[] res = new int[10000];
            int len = 0;
            LinkedList<int[]> stack = new LinkedList<>();
            while (head != null) {
                while (!stack.isEmpty() && stack.peek()[0] < head.val) {
                    int idx = stack.pop()[1];
                    res[idx] = head.val;
                }
                stack.push(new int[]{head.val, len++});
                head = head.next;
            }
            while (!stack.isEmpty()) res[stack.pop()[1]] = 0;
            return Arrays.copyOfRange(res, 0, len);
        }
    }
}
