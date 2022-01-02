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

    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

            int res = 0, lo = -1, hi = -1;
            for (int[] v : intervals) {
                boolean loIn = v[0] <= lo, hiIn = v[0] <= hi;
                if (hiIn && loIn) continue;

                res += (hiIn ? 1 : 2);

                lo = (hiIn ? hi : v[1] - 1);
                hi = v[1];
            }
            return res;
        }
    }
}
