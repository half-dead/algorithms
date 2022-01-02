package p1000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-boxes/
 *
 * @author half-dead
 */
public class Puzzle546_RemoveBoxes {

    public static void main(String[] args) {
        Puzzle546_RemoveBoxes p = new Puzzle546_RemoveBoxes();
        Solution s = p.new Solution();
        System.out.println(s.removeBoxes(new int[]{
                1, 3, 2, 2, 2, 3, 4, 3, 1
        })); // 23
        System.out.println(s.removeBoxes(new int[]{
                1, 2, 2, 1, 2, 2, 1
        })); // 21
        System.out.println(s.removeBoxes(new int[]{
                8, 2, 2, 9, 6, 4, 3, 10, 2, 10, 10, 1, 10, 2, 9, 5, 2, 9, 7, 4, 10, 2, 3, 8, 3, 6, 10, 9, 7, 10, 9, 7, 5, 3, 4, 1, 3, 10, 2, 6, 1, 1, 1, 2, 5, 5, 10, 8, 9, 9
        })); // 146
        System.out.println(s.removeBoxes(new int[]{
                3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7
        })); // 136
    }

    class Solution {
        public int removeBoxes(int[] boxes) {
            int n = boxes.length;
            int[][][] dp = new int[n][n][n];
            int r = dfs(dp, boxes, 0, n - 1, 0);
            System.out.println(Arrays.deepToString(dp));
            return r;
        }

        private int dfs(int[][][] dp, int[] boxes, int left, int right, int k) {
            if (left > right) return 0;
            if (dp[left][right][k] != 0) return dp[left][right][k];
            while (left < right && boxes[right - 1] == boxes[right]) {
                right--;
                k++;
            }
            dp[left][right][k] = dfs(dp, boxes, left, right - 1, 0) + (k + 1) * (k + 1);
            for (int i = left; i < right; i++)
                if (boxes[i] == boxes[right])
                    dp[left][right][k] = Math.max(dp[left][right][k], dfs(dp, boxes, left, i, k + 1) + dfs(dp, boxes, i + 1, right - 1, 0));
            return dp[left][right][k];
        }
    }

    class Solution1 {
        public int removeBoxes(int[] boxes) {
            int len = boxes.length;
            if (len < 2) return len;

            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) dp[i][i] = 1;

            int[] lens = new int[len];
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.putIfAbsent(boxes[i], new ArrayList<>());
                map.get(boxes[i]).add(i);

                if (i == 0 || boxes[i] != boxes[i - 1]) lens[i] = 1;
                else lens[i] = lens[i - 1] + 1;
            }

            for (int partLen = 2; partLen <= len; partLen++) {
                for (int begin = 0; begin < len; begin++) {
                    int end = begin + partLen - 1;
                    if (end >= len) break;

                    if (lens[end] == partLen) {
                        dp[begin][end] = lens[end] * lens[end];
                    } else {
                        int max = dp[begin][end - 1] + 1;
                        ArrayList<Integer> indexes = map.get(boxes[end]);
                        int prev = begin, lastLen = 1, scores = 0;
                        for (int index : indexes) {
                            if (index < begin) continue;
                            if (index >= end) break;
                            lastLen++;
                            scores += index > prev ? dp[prev][index - 1] : 0;
                            prev = index + 1;
                            max = Math.max(max, scores + lastLen * lastLen + dp[prev][end - 1]);
                        }
                        prev = end;
                        lastLen = 1;
                        scores = 0;
                        for (int i = indexes.size() - 1; i >= 0; i--) {
                            int index = indexes.get(i);
                            if (index >= end) continue;
                            if (index < begin) break;
                            lastLen++;
                            scores += dp[index + 1][prev - 1];
                            prev = index - 1;
                            max = Math.max(max, scores + lastLen * lastLen + (prev >= begin ? dp[begin][prev] : 0));
                        }
                        dp[begin][end] = max;
                    }
                }
            }
            return dp[0][len - 1];
        }

        private void pt(int[][] dp) {
            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }
        }
    }

}
