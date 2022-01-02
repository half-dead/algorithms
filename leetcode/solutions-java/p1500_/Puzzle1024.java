package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/video-stitching/
 *
 * @author half-dead
 */
public class Puzzle1024 {
    public static void main(String[] args) {
        Solution s = new Puzzle1024().new Solution();
        System.out.println(s.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
        System.out.println(s.videoStitching(new int[][]{{0, 1}, {1, 2}}, 5));
    }

    // Greedy
    class Solution {
        public int videoStitching(int[][] clips, int t) {
            int[] map = new int[t + 1];
            for (int[] clip : clips) {
                if (clip[0] > t) continue;
                map[clip[0]] = Math.max(map[clip[0]], Math.min(t, clip[1]));
            }
            int ans = 0;
            for (int from = 0, to = 0, nextTo = 0; to < t; from = to + 1, to = nextTo, ans++) {
                for (int i = from; i <= to; i++)
                    nextTo = Math.max(nextTo, map[i]);
                if (nextTo <= to) return -1;
            }
            return ans;
        }
    }

    // Floyd-Warshall, O(N^3), 3ms
    class FWSolution {
        public int videoStitching(int[][] clips, int t) {
            int[][] dp = new int[t + 1][t + 1];
            for (int[] row : dp) Arrays.fill(row, -1);

            for (int[] clip : clips)
                for (int from = clip[0], max = Math.min(clip[1], t); from <= max; from++)
                    for (int to = from; to <= max; to++)
                        dp[from][to] = 1;


            for (int via = 1; via < t; via++) {
                for (int from = 0; from < via; from++) {
                    if (dp[from][via] > 0) {
                        for (int to = via + 1; to <= t; to++) {
                            if (dp[via][to] > 0) {
                                int num = dp[from][via] + dp[via][to];
                                dp[from][to] = dp[from][to] == -1 ? num : Math.min(dp[from][to], num);
                            }
                        }
                    }
                }
            }
            return dp[0][t];
        }
    }
}
