package p2000_;

/**
 * https://leetcode.com/problems/maximum-matrix-sum/
 *
 * @author half-dead
 */
public class Puzzle1975 {

    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            long sum = 0L;
            int neg = 0, min = 100000;
            for (int[] row : matrix)
                for (int e : row) {
                    if (e < 0) neg++;
                    sum += e = Math.abs(e);
                    min = Math.min(min, e);
                }
            if (neg % 2 != 0) sum = sum - min - min;
            return sum;
        }
    }
}
