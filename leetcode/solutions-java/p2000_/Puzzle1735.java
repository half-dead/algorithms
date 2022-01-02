package p2000_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author half-dead
 */
public class Puzzle1735 {

    public static void main(String[] args) {
        Solution s = new Puzzle1735().new Solution();
        System.out.println(Arrays.toString(s.waysToFillArray(new int[][]{
                {73, 660}
        })));
    }

    class Solution {
        int mod = (int) (1e9 + 7), q = 10000;
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] primes = new boolean[q + 1];

        public int[] waysToFillArray(int[][] queries) {
            Arrays.fill(primes, true);
            primes[0] = primes[1] = false;
            for (int step = 2; step < primes.length; step++) {
                for (int i = step + step; i < primes.length; i += step) {
                    primes[i] = false;
                }
            }
            int m = queries.length;
            int[] res = new int[m];

            for (int i = 0; i < m; i++) {
                res[i] = dfs(queries[i][0], queries[i][1]);
            }
            return res;
        }

        private int dfs(int n, int p) {
            if (primes[p]) return n;
            if (p == 1 || n == 1) return 1;

            int key = n * q + p;
            int cache = map.getOrDefault(key, -1);
            if (cache >= 0) return cache;

            long cnt = 0L;
            for (int i = 1; i <= p; i++) {
                if (p % i != 0) continue;

                cnt += dfs(n - 1, p / i);
                cnt %= mod;
            }

            int ans = (int) (cnt % mod);
            map.put(key, ans);
            return ans;
        }
    }
}
