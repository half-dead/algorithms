package p2000_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 *
 * @author half-dead
 */
public class Puzzle1944 {

    // monotone stack
    class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] res = new int[n];

            Deque<Integer> stack = new LinkedList<>();
            for (int i = n - 1; i >= 0; i--) {
                while (stack.size() > 0 && heights[i] >= stack.peek()) {
                    stack.pop();
                    res[i]++;
                }
                if (stack.size() > 0) res[i]++;

                stack.push(heights[i]);
            }
            return res;
        }
    }
}
