package p1500_;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-well-performing-interval/
 *
 * @author half-dead
 */
public class Puzzle1124 {

    // a more generalize solution using monotonic stack
    class Solution {
        public int longestWPI(int[] hours) {
            int len = hours.length;
            int[] sum = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                sum[i] = sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            }

            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i <= len; i++) {
                if (stack.isEmpty() || sum[stack.peek()] > sum[i]) {
                    stack.push(i);
                }
            }


            int res = 0;
            for (int j = len; j >= 0; j--) {
                while (!stack.isEmpty() && sum[stack.peek()] < sum[j]) {
                    res = Math.max(res, j - stack.pop());
                }
            }
            return res;
        }
    }

    class MapSolution {
        public int longestWPI(int[] hours) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int diff = 0, len = hours.length, max = 0;
            for (int i = 0; i < len; i++) {
                diff += hours[i] > 8 ? 1 : -1;

                if (diff > 0) max = i + 1;
                else {
                    Integer prev = map.get(diff - 1);
                    if (prev != null) {
                        max = Math.max(max, i - prev);
                    }
                }
                map.putIfAbsent(diff, i);
            }
            return max;
        }
    }
}
