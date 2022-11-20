package p2500_;

/**
 * https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/
 */
public class Puzzle2455 {
    class Solution {
        public int averageValue(int[] nums) {
            int sum = 0, cnt = 0;
            for (int v : nums) {
                if (v % 2 == 0 && v % 3 == 0) {
                    sum += v;
                    cnt++;
                }
            }
            return cnt == 0 ? 0 : (sum / cnt);
        }
    }
}
