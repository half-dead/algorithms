package p1500_;

/**
 * https://leetcode.com/problems/count-vowels-permutation/
 *
 * @author half-dead
 */
public class Puzzle1220 {

    public static void main(String[] args) {
        Solution s = new Puzzle1220().new Solution();
        System.out.println(s.countVowelPermutation(1));
        System.out.println(s.countVowelPermutation(2));
        System.out.println(s.countVowelPermutation(5));
        System.out.println(s.countVowelPermutation(144));
    }

    class Solution {

        public int countVowelPermutation(int n) {
            // ea ia ua
            // ae ie
            // ei oi
            // io
            // iu ou

            // a e i o u
            // 0 1 2 3 4
            int mod = (int) (1e9 + 7);
            long[] dp = new long[5];
            for (int i = 0; i < 5; i++) dp[i] = 1;

            while (--n > 0) {
                long[] next = new long[5];
                next[0] = dp[1] + dp[2] + dp[4];
                next[1] = dp[0] + dp[2];
                next[2] = dp[1] + dp[3];
                next[3] = dp[2];
                next[4] = dp[2] + dp[3];
                dp = next;
                for (int i = 0; i < 5; i++) dp[i] %= mod;
            }
            return (int) ((dp[0] + dp[1] + dp[2] + dp[3] + dp[4]) % mod);
        }
    }
}
