package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/restore-the-array/
 *
 * @author half-dead
 */
public class Puzzle1416 {

    public static void main(String[] args) {
        Solution s = new Puzzle1416().new Solution();
        System.out.println(s.numberOfArrays("40778078617132112142962076547684027549535712957417423356755213145303876076" +
                "318295243234842225254655969117116118144037012098763489545814044795207974943996132598262946253173837403" +
                "2416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415", 823924906));
    }

    class Solution {
        int n, k, mod = (int) (1e9 + 7);
        int[] dp;
        char[] cs;

        public int numberOfArrays(String s, int k) {
            this.k = k;
            n = s.length();
            cs = s.toCharArray();
            dp = new int[n];

            Arrays.fill(dp, -1);
            return dfs(0);
        }

        int dfs(int i) {
            if (i == n) return 1;
            if (dp[i] >= 0) return dp[i];
            if (cs[i] == '0') return dp[i] = 0;

            long x = 0, cnt = 0L;
            for (int j = i; j < n; ) {
                x = x * 10 + (cs[j] - '0');
                if (x > k) break;
                cnt += dfs(++j);
            }
            return dp[i] = (int) (cnt % mod);
        }
    }
}
