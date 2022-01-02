package p1500_;

/**
 * https://leetcode.com/problems/last-stone-weight-ii/
 *
 * @author half-dead
 */
public class Puzzle1049 {
    public static void main(String[] args) {
        Solution s = new Puzzle1049().new Solution();
        System.out.println(s.lastStoneWeightII(new int[]{8, 2, 4, 4, 8}));
        System.out.println(s.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(s.lastStoneWeightII(new int[]{1, 2, 4, 8, 16, 32, 64, 12, 25, 51}));
    }

    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int stone : stones) sum += stone;

            int len = sum / 2 + 1;
            boolean[] dp = new boolean[len];
            dp[0] = true;

            for (int stone : stones) for (int i = len - 1; i >= stone; i--) dp[i] |= dp[i - stone];

            for (int half = sum >> 1; half >= 0; half--) if (dp[half]) return sum - half - half;
            return sum;
        }
    }
}
