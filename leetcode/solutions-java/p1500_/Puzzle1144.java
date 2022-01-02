package p1500_;

/**
 * https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
 *
 * @author half-dead
 */
public class Puzzle1144 {

    class Solution {
        public int movesToMakeZigzag(int[] a) {
            int[] res = new int[2];
            for (int i = 0, len = a.length; i < len; i++) {
                int min = Math.min(i > 0 ? a[i - 1] : 1000, i + 1 < len ? a[i + 1] : 1000);
                if (a[i] >= min) res[i & 1] += a[i] - min + 1;
            }
            return Math.min(res[0], res[1]);
        }
    }

}
