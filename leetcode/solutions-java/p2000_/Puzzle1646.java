package p2000_;

/**
 * https://leetcode.com/problems/get-maximum-in-generated-array/
 *
 * @author half-dead
 */
public class Puzzle1646 {

    public static void main(String[] args) {
        Solution s = new Puzzle1646().new Solution();
        s.getMaximumGenerated(100);
    }

    class Solution {
        public int getMaximumGenerated(int n) {
            if (n < 2) return n;

            int[] res = new int[n + 1];
            res[1] = 1;
            int max = 0;
            for (int i = 2; i <= n; i++) {
                if (i % 2 == 0) {
                    res[i] = res[i / 2];
                } else {
                    res[i] = res[i / 2] + res[i / 2 + 1];
                }
                max = Math.max(max, res[i]);
            }
            return max;
        }
    }
}
