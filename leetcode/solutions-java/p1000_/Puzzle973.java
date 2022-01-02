package p1000_;

import util.Print;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/solution/
 *
 * @author half-dead
 */
public class Puzzle973 {
    public static void main(String[] args) {
        Solution s = new Puzzle973().new Solution();
        Print.pt(s.kClosest(new int[][]{{9, 0}, {-4, -2}, {7, 10}, {3, -9}, {9, 1}, {-5, -1}}, 5));
        Print.pt(s.kClosest(new int[][]{{1, 3}, {2, 2}}, 1));
        Print.pt(s.kClosest(new int[][]{{1, 3}, {2, 2}, {-2, 2}}, 1));
    }

    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            int lo = 0, hi = points.length - 1;
            while (lo < hi) {
                int pivot = partition(points, lo, hi);
                if (pivot == k) break;
                else if (pivot > k) hi = pivot - 1;
                else lo = pivot + 1;
            }
            return Arrays.copyOf(points, k);
        }

        private int partition(int[][] points, int lo, int hi) {
            int[] pivot = points[lo];
            int d = distance(pivot);
            while (lo < hi) {
                while (lo < hi && distance(points[hi]) >= d) hi--;
                points[lo] = points[hi];

                while (lo < hi && distance(points[lo]) <= d) lo++;
                points[hi] = points[lo];
            }
            points[lo] = pivot;
            return lo;
        }

        private int distance(int[] p) {
            return p[0] * p[0] + p[1] * p[1];
        }
    }


    class SortSolution {
        public int[][] kClosest(int[][] points, int K) {
            Arrays.sort(points, (p, q) -> {
                return p[0] * p[0] + p[1] * p[1] - q[0] * q[0] - q[1] * q[1];
            });
            int[][] res = new int[K][2];
            System.arraycopy(points, 0, res, 0, K);
            return res;
        }
    }
}
