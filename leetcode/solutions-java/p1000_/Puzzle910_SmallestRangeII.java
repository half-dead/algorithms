package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/smallest-range-ii/
 *
 * @author half-dead
 */
public class Puzzle910_SmallestRangeII {
    public static void main(String[] args) {
        Puzzle910_SmallestRangeII p = new Puzzle910_SmallestRangeII();
        Solution s = p.new Solution();
        System.out.println(s.smallestRangeII(new int[]{1}, 0));
        System.out.println(s.smallestRangeII(new int[]{0, 10}, 2));
        System.out.println(s.smallestRangeII(new int[]{1, 3, 6}, 3));
        System.out.println(s.smallestRangeII(new int[]{3, 4, 7, 0}, 5));
        System.out.println(s.smallestRangeII(new int[]{1, 6, 2, 4, 8, 8}, 2));
    }

    class Solution {
        public int smallestRangeII(int[] a, int k) {
            Arrays.sort(a);
            int len = a.length, diff = a[len - 1] - a[0], min = a[0] + k, max = a[len - 1] - k;
            for (int i = 1; i < len; i++)
                diff = Math.min(diff, Math.max(a[i - 1] + k, max) - Math.min(a[i] - k, min));
            return diff;
        }
    }
}
