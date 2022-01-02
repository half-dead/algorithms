package p1000_;

/**
 * https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 *
 * @author half-dead
 */
public class Puzzle915 {

    class Solution {
        public int partitionDisjoint(int[] A) {
            int n = A.length;
            int[] max = new int[n], min = new int[n];
            int maxn = A[0], minn = A[n - 1];
            for (int i = 0; i < n; i++) {
                max[i] = maxn = Math.max(maxn, A[i]);
            }
            for (int i = n - 1; i >= 0; i--) {
                min[i] = minn = Math.min(minn, A[i]);
            }
            int idx = 0;
            while (idx < n - 1 && max[idx] > min[idx + 1]) idx++;
            return idx + 1;
        }
    }

    class Solution0 {
        public int partitionDisjoint(int[] a) {
            int idx = 0;
            for (int i = 1, maxLeft = a[0], max = maxLeft; i < a.length; i++) {
                if (maxLeft > a[i]) {
                    maxLeft = max;
                    idx = i;
                } else max = Math.max(max, a[i]);
            }
            return idx + 1;
        }
    }
}
