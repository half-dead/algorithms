package p1500_;

/**
 * https://leetcode.com/problems/prime-arrangements/
 *
 * @author half-dead
 */
public class Puzzle1175 {
    class Solution {
        public int numPrimeArrangements(int n) {
            boolean[] nonPrimes = new boolean[101];
            nonPrimes[1] = true;
            for (int i = 2; i <= 10; i++) {
                for (int j = i; i * j <= 101; j++) {
                    nonPrimes[i * j] = true;
                }
            }
            int countPrimes = 0, countNonPrimes = 0;
            for (int i = 1; i <= n; i++) {
                if (nonPrimes[i]) countNonPrimes++;
                else countPrimes++;
            }
            int mod = 1000000007;
            long res = 1;
            while (countPrimes > 0) res = (res * countPrimes--) % mod;
            while (countNonPrimes > 0) res = (res * countNonPrimes--) % mod;
            return (int) res;
        }
    }
}
