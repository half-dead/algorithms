package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-values-from-labels/
 *
 * @author half-dead
 */
public class Puzzle1090 {

    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int wanted, int limit) {
            int n = values.length, sum = 0, cnt = 0;
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = values[i];
                arr[i][1] = labels[i];
            }
            Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            int[] used = new int[20001];
            for (int[] p : arr) {
                if (used[p[1]] < limit) {
                    used[p[1]]++;
                    sum += p[0];
                    if (++cnt == wanted) break;
                }
            }
            return sum;
        }
    }
}
