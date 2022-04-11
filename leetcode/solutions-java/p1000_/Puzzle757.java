package p1000_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle757 {

    public static void main(String[] args) {
        Solution s = new Puzzle757().new Solution();
        System.out.println(s.intersectionSizeTwo(new int[][]{
                {1, 3}, {4, 9}, {0, 10}, {6, 7}, {1, 2}, {0, 6}, {7, 9}, {0, 1}, {2, 5}, {6, 8}
        }));
    }

    // sort + greedy
    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            // sort by end asc, then start desc, this is the tricky part
            Arrays.sort(intervals, (a, b) -> {
                int d = a[1] - b[1];
                return d == 0 ? b[0] - a[0] : d;
            });

            int n = intervals.length, ans = 0;
            int lo = intervals[0][1] - 1, hi = intervals[0][1];
            for (int i = 1; i < n; i++) {
                int left = intervals[i][0], right = intervals[i][1];
                if (left > lo && left <= hi) {
                    ans++;
                    lo = hi;
                    hi = right;
                } else if (left > hi) {
                    ans += 2;
                    lo = right - 1;
                    hi = right;
                }
            }
            return ans + 2;
        }
    }
}
