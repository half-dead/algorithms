package p2500_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/
 *
 * @author half-dead
 */
public class Puzzle2280 {

    class Solution {
        public int minimumLines(int[][] sp) {
            if (sp.length < 2) return 0;

            Arrays.sort(sp, Comparator.comparingInt(a -> a[0]));

            int[] k = getK(sp[0], sp[1]);
            int res = 1;
            for (int i = 2; i < sp.length; i++) {
                int[] nk = getK(sp[i - 1], sp[i]);
                if (!eq(k, nk)) {
                    res++;
                    k = nk;
                }
            }
            return res;
        }

        int[] getK(int[] a, int[] b) {
            return new int[]{b[1] - a[1], b[0] - a[0]};
        }

        boolean eq(int[] a, int[] b) {
            return a[0] * (long) b[1] == a[1] * (long) b[0];
        }
    }

}
