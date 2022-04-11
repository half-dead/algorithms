package p2500_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/
 *
 * @author half-dead
 */
public class Puzzle2163 {

    public static void main(String[] args) {
        Solution s = new Puzzle2163().new Solution();
        System.out.println(s.minimumDifference(new int[]{
                16, 46, 43, 41, 42, 14, 36,
                49, 50, 28, 38, 25, 17, 5,
                18, 11, 14, 21, 23, 39, 23
        }));
    }

    class Solution {
        public long minimumDifference(int[] a) {
            int n = a.length, unit = n / 3;
            long prefix = 0, suffix = 0, res = Long.MAX_VALUE;
            return res;
        }
    }

}
