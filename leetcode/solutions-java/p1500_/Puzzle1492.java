package p1500_;

/**
 * https://leetcode.com/problems/the-kth-factor-of-n/
 *
 * @author half-dead
 */
public class Puzzle1492 {

    class Solution {
        public int kthFactor(int n, int k) {
            boolean[] a = new boolean[n + 1];
            for (int f = 1; f <= n; f++) {
                if (n % f == 0) a[f] = true;
            }
            int c = 0;
            for (int i = 0; i <= n; i++) {
                if (a[i] && ++c == k) {
                    return i;
                }
            }
            return -1;
        }
    }
}
