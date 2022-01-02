package p1500_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle1288 {

    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int ans = 1, end = intervals[0][1];
            for (int[] it : intervals) {
                if (it[1] > end) {
                    ans++;
                    end = it[1];
                }
            }
            return ans;
        }
    }
}
