package p0500_;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sliding-window-median/
 *
 * @author half-dead
 */
public class Puzzle480_SlidingWindowMedian {
    public static void main(String[] args) {
        Puzzle480_SlidingWindowMedian p = new Puzzle480_SlidingWindowMedian();
        Solution s = p.new Solution();
        System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            double[] result = new double[nums.length - k + 1];
            int index = 0, limit = (k + 1) / 2, k1 = k - 1;
            PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()), hi = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                hi.add(nums[i]);
                if (lo.size() > 0 && lo.peek() > hi.peek()) {
                    lo.add(hi.poll());
                    hi.add(lo.poll());
                }
                if (hi.size() > limit) lo.add(hi.poll());
                if (i >= k1) {
                    result[index++] = hi.size() > lo.size() ? hi.peek() : (hi.peek() / 2.0d + lo.peek() / 2.0d);
                    int remove = nums[i - k + 1];
                    if (remove < hi.peek()) lo.remove(remove);
                    else hi.remove(remove);
                }
            }
            return result;
        }
    }

}
