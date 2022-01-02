package p1500_;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 *
 * @author half-dead
 */
public class Puzzle1438 {

    public static void main(String[] args) {
        Solution s = new Puzzle1438().new Solution();
        System.out.println(s.longestSubarray(new int[]{24, 12, 71, 33, 5, 87, 10, 11, 3, 58, 2, 97, 97, 36, 32, 35, 15, 80, 24, 45, 38, 9, 22, 21, 33, 68, 22, 85, 35, 83, 92, 38, 59, 90, 42, 64, 61, 15, 4, 40, 50, 44, 54, 25, 34, 14, 33, 94, 66, 27, 78, 56, 3, 29, 3, 51, 19, 5, 93, 21, 58, 91, 65, 87, 55, 70, 29, 81, 89, 67, 58, 29, 68, 84, 4, 51, 87, 74, 42, 85, 81, 55, 8, 95, 39}, 87));
    }

    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> maxQ = new LinkedList<>(), minQ = new ArrayDeque<>();
            int len = nums.length, from = 0, to = 0;
            while (to < len) {
                int n = nums[to];

                while (!maxQ.isEmpty() && n > maxQ.peekLast()) maxQ.pollLast();
                while (!minQ.isEmpty() && n < minQ.peekLast()) minQ.pollLast();

                maxQ.add(n);
                minQ.add(n);

                if (maxQ.peek() - minQ.peek() > limit) {
                    if (maxQ.peek() == nums[from]) maxQ.poll();
                    if (minQ.peek() == nums[from]) minQ.poll();
                    ++from;
                }
                to++;
            }
            return to - from;
        }
    }

    // sliding window + TreeMap, 76ms
    class TreeMapSolution {
        public int longestSubarray(int[] nums, int limit) {
            int len = nums.length, from = 0, to = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (to < len) {
                map.put(nums[to], map.getOrDefault(nums[to], 0) + 1);
                if (map.lastKey() - map.firstKey() > limit) {
                    int cnt = map.get(nums[from]);
                    if (cnt == 1) map.remove(nums[from]);
                    else map.replace(nums[from], cnt - 1);
                    from++;
                }
                to++;
            }
            return to - from;
        }
    }
}
