package p2500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/
 *
 * @author half-dead
 */
public class Puzzle2216 {

    class Solution {
        public int minDeletion(int[] nums) {
            LinkedList<Integer> q = new LinkedList<>();
            for (int x : nums) {
                if (q.size() % 2 == 0 || x != q.peekLast()) q.addLast(x);
            }
            if (q.size() % 2 != 0) q.pollLast();
            return nums.length - q.size();
        }
    }
}
