package p0500_;

import util.Print;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/find-right-interval/
 *
 * @author half-dead
 */
public class Puzzle436 {
    public static void main(String[] args) {
        Solution s = new Puzzle436().new Solution();
        Print.pt(s.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
    }

    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int n = intervals.length;

            int[][] data = new int[n][2];
            for (int i = 0; i < n; i++) data[i] = new int[]{intervals[i][0], i};
            Arrays.sort(data, Comparator.comparingInt(a -> a[0]));

            int[] copy = new int[n];
            for (int i = 0; i < n; i++) copy[i] = data[i][0];

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int pos = Arrays.binarySearch(copy, intervals[i][1]);
                if (pos < 0) pos = -pos - 1;
                res[i] = pos >= n ? -1 : data[pos][1];
            }
            return res;
        }
    }
}
