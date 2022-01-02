package p1000_;

/**
 * Sum of Even Numbers After Queries
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 *
 * @author half-dead
 */
public class Puzzle985 {
    class Solution {
        public int[] sumEvenAfterQueries(int[] a, int[][] q) {
            int sum = 0, len = q.length;
            int[] result = new int[len];
            for (int i : a) if ((i & 1) == 0) sum += i;

            for (int i = 0; i < len; i++) {
                int idx = q[i][1], before = a[idx], after = a[idx] + q[i][0];

                if ((before & 1) == 0) sum -= before;
                if ((after & 1) == 0) sum += after;
                a[idx] = after;
                result[i] = sum;
            }
            return result;
        }
    }
}
