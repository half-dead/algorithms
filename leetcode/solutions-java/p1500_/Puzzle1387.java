package p1500_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle1387 {
    public static void main(String[] args) {
        Solution s = new Puzzle1387().new Solution();
        s.getKth(1, 1000, 1);
    }

    // dfs with memo, 26ms
    class Solution {
        public int getKth(int lo, int hi, int k) {
            int[] cache = new int[250505];
            for (int n = lo; n <= hi; n++) dfs(cache, n);
            int[][] a = new int[hi - lo + 1][2];
            for (int n = lo; n <= hi; n++) {
                a[n - lo][0] = cache[n];
                a[n - lo][1] = n;
            }
            Arrays.sort(a, (e, f) -> e[0] == f[0] ? e[1] - f[1] : e[0] - f[0]);
            return a[k - 1][1];
        }

        int dfs(int[] cache, int n) {
            if (cache[n] > 0) return cache[n];
            if (n == 1) return 0;
            int power = (n & 1) == 1 ? dfs(cache, n * 3 + 1) : dfs(cache, n >> 1);
            return cache[n] = ++power;
        }
    }

    // BruteForce, 41ms
    class BruteForceSolution {
        public int getKth(int lo, int hi, int k) {
            int[][] a = new int[hi - lo + 1][2];
            for (int n = lo; n <= hi; n++) a[n - lo][1] = n;
            for (int n = lo; n <= hi; n++) {
                int power = 0, prev = n;
                while (prev != 1) {
                    if (prev % 2 == 0) {
                        prev = prev >> 1;
                    } else {
                        prev = prev * 3 + 1;
                    }
                    power++;
                }
                a[n - lo][0] = power;
            }
            Arrays.sort(a, (e, f) -> e[0] == f[0] ? e[1] - f[1] : e[0] - f[0]);
            return a[k - 1][1];
        }
    }

    // Graph, 39ms
    class GraphSolution {
        public int getKth(int lo, int hi, int k) {
            int[] g = new int[250505];
            int[] ps = new int[250505];
            outer:
            for (int n = lo; n <= hi; n++) {
                int power = 0, prev = n, next;
                while (prev != 1) {
                    if (ps[prev] > 0) {
                        ps[n] = ps[prev] + power;
                        continue outer;
                    }
                    if (prev % 2 == 0) {
                        next = prev >> 1;
                    } else {
                        next = prev * 3 + 1;
                    }
                    g[prev] = next;
                    prev = next;
                    power++;
                }

                for (prev = n; prev != 1; ) {
                    ps[prev] = power--;
                    prev = g[prev];
                }
            }

            int[][] a = new int[hi - lo + 1][2];
            for (int n = lo; n <= hi; n++) {
                a[n - lo][0] = ps[n];
                a[n - lo][1] = n;
            }
            Arrays.sort(a, (e, f) -> e[0] == f[0] ? e[1] - f[1] : e[0] - f[0]);
            return a[k - 1][1];
        }
    }
}
