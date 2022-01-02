package p1000_;

/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 *
 * @author half-dead
 */
public class Puzzle923 {
    class Solution {
        public int threeSumMulti(int[] a, int target) {
            long res = 0;
            long[] cnts = new long[101];
            for (int n : a) cnts[n]++;

            // i < j && j < k
            for (int i = 0; i < 101; i++) {
                if (cnts[i] == 0) continue;

                int need = target - i, j = i + 1, k = Math.min(100, need - j);
                while (j < k) {
                    int sum = j + k;
                    if (sum == need) {
                        if (cnts[j] > 0 && cnts[k] > 0)
                            res += cnts[i] * cnts[j] * cnts[k];
                        j++;
                        k--;
                    } else if (sum > need) k--;
                    else j++;
                }
            }

            int onethird = target / 3;
            for (int i = 0; i < 101; i++) {
                long cnt = cnts[i];
                if (cnt < 2) continue;

                // i == j == k
                if (i == onethird && i * 3 == target) {
                    if (cnt >= 3) res += cnt * (cnt - 1) * (cnt - 2) / 6;
                    continue;
                }

                // i == j != k
                int need = target - i - i;
                if (need >= 0 && need < 101 && cnts[need] > 0) res += cnts[need] * cnt * (cnt - 1) / 2;
            }
            return (int) (res % 1000000007);
        }
    }

}
