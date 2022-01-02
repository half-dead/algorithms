package p1500_;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 *
 * @author half-dead
 */
public class Puzzle1027 {

    // very clever solution
    class Solution {
        int longestArithSeqLength(int[] a) {
            int len = a.length, max = 0;
            // dp[i][j] stores the length of the longest seq ends at j with diff == A[i] - A[j], minus 2
            int[][] dp = new int[len][len];

            // idx[v] is the last index of value v seen so far
            int[] idx = new int[10001];
            Arrays.fill(idx, -1);

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int prev = 2 * a[i] - a[j];
                    // check if there is a number prev exists: prev - a[i] = a[i] - a[j]
                    if (prev < 0 || prev > 10000 || idx[prev] < 0) continue;

                    int pos = idx[prev];
                    dp[i][j] = dp[pos][i] + 1;
                    max = Math.max(max, dp[i][j]);
                }
                idx[a[i]] = i;
            }
            return max + 2;
        }
    }

    class MapSolution {
        public int longestArithSeqLength(int[] a) {
            int len = a.length, max = 2;

            HashMap<Integer, Integer>[] dp = new HashMap[len];
            for (int i = 1; i < len; i++) {
                dp[i] = new HashMap<>();
                for (int j = 0; j < i; j++) {
                    int diff = a[j] - a[i];
                    if (j == 0) {
                        dp[i].put(diff, 2);
                    } else {
                        Integer prev = dp[j].get(diff);
                        if (prev != null) {
                            max = Math.max(max, prev + 1);
                            dp[i].put(diff, prev + 1);
                        } else {
                            dp[i].put(diff, 2);
                        }
                    }
                }
            }
            return max;
        }
    }
}
