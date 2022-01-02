package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 *
 * @author half-dead
 */
public class Puzzle646_MaximumLengthOfPairChain {

    // Greedy, reverse
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
            int res = 0;
            int right = Integer.MAX_VALUE;
            for (int i = pairs.length - 1; i >= 0; i--) {
                if (right > pairs[i][1]) {
                    res++;
                    right = pairs[i][0];
                }
            }
            return res;
        }
    }

    // DP TRY AGAIN
    class DpSolution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
            int[] dp = new int[pairs.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < pairs.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (pairs[j][1] < pairs[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int max = 1;
            for (int c : dp) {
                max = Math.max(max, c);
            }
            return max;
        }
    }

    class Solution1 {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
            int cur = Integer.MIN_VALUE, ans = 0;
            for (int[] pair : pairs) {
                if (cur < pair[0]) {
                    cur = pair[1];
                    ans++;
                }
            }
            return ans;
        }
    }
}