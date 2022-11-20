package p2500_;

/**
 * https://leetcode.cn/problems/number-of-common-factors/
 */
public class Puzzle2427 {

    class Solution {
        public int commonFactors(int a, int b) {
            int gcd = gcd(a, b), cnt = 0;
            for (int i = 2; i <= gcd / 2; i++) {
                if (gcd % i == 0) {
                    cnt++;
                }
            }
            return cnt + 1 + (gcd > 1 ? 1 : 0);
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}
