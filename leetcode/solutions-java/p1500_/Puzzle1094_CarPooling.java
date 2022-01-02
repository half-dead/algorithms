package p1500_;

/**
 * https://leetcode.com/problems/car-pooling/
 *
 * @author half-dead
 */
public class Puzzle1094_CarPooling {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] count = new int[1001];
            for (int[] trip : trips) {
                count[trip[1]] += trip[0];
                count[trip[2]] -= trip[0];
            }
            int sum = 0;
            for (int c : count) if ((sum += c) > capacity) return false;
            return true;

        }
    }
}
