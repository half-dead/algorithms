package p1000_;

/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 *
 * @author half-dead
 */
public class Puzzle945 {
    class Solution {
        public int minIncrementForUnique(int[] A) {
            int[] cnt = new int[40001];
            for (int n : A) cnt[n]++;
            int res = 0;
            for (int i = 0; i < 40000; i++) {
                if (cnt[i] > 1) {
                    cnt[i + 1] += cnt[i] - 1;
                    res += cnt[i] - 1;
                }
            }
            return res + (cnt[40000] - 1) * cnt[40000] / 2;
        }
    }
}
