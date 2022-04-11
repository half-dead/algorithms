package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
 *
 * @author half-dead
 */
public class Puzzle2136 {

    public static void main(String[] args) {
        Solution s = new Puzzle2136().new Solution();
        System.out.println(s.earliestFullBloom(new int[]{
                3, 11, 29, 4, 4, 26, 26, 12, 13, 10, 30, 19, 27, 2, 10
        }, new int[]{
                10, 13, 22, 17, 18, 15, 21, 11, 24, 14, 18, 23, 1, 30, 6
        }));
    }

    // greedy, sorting
    class Solution {
        public int earliestFullBloom(int[] pt, int[] gt) {
            int n = pt.length, sum = 0, res = 0;

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) arr[i] = new int[]{pt[i], gt[i]};
            Arrays.sort(arr, (a, b) -> b[1] - a[1]);

            for (int i = 0; i < n; i++) {
                sum += arr[i][0];
                res = Math.max(res, sum + arr[i][1]);
            }
            return res;
        }
    }
}
