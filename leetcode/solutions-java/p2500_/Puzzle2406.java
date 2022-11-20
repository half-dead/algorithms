package p2500_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/
 */
public class Puzzle2406 {

    // Line sweep
    class MySolution {
        public int minGroups(int[][] intervals) {
            int[] cnts = new int[1000002];
            for (int[] interval : intervals) {
                cnts[interval[0]] += 1;
                cnts[interval[1] + 1] -= 1;
            }

            int curr = 0, res = 0;
            for (int v : cnts) {
                curr += v;
                res = Math.max(curr, res);
            }
            return res;
        }


    }

    class Solution {
        public int minGroups(int[][] intervals) {
            int res = 0, cur = 0, n = intervals.length;
            int[][] arr = new int[n * 2][2];
            for (int i = 0; i < n; ++i) {
                arr[i * 2] = new int[]{intervals[i][0], 1};
                arr[i * 2 + 1] = new int[]{intervals[i][1] + 1, -1};
            }
            Arrays.sort(arr, (a, b) -> {
                int d = a[0] - b[0];
                return d == 0 ? a[1] - b[1] : d;
            });
            for (int[] a : arr)
                res = Math.max(res, cur += a[1]);
            return res;
        }
    }
}
