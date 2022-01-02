package p2500_;

import struct.ListNode;

/**
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 *
 * @author half-dead
 */
public class Puzzle2058 {

    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            ListNode p = null, c = head, n = null;
            int first = -1, last = -1, min = Integer.MAX_VALUE, i = 0;
            while (c != null) {
                n = c.next;

                if (p != null && n != null) {

                    if ((c.val < p.val && c.val < n.val) || (c.val > p.val && c.val > n.val)) {
                        if (first < 0) first = i;
                        if (last > 0) min = Math.min(i - last, min);

                        last = i;
                    }
                }
                p = c;
                c = n;
                i++;
            }
            return first == last ? new int[]{-1, -1} : new int[]{min, last - first};
        }
    }
}
