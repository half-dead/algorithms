package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-trees-with-factors/
 *
 * @author half-dead
 */
public class Puzzle823 {
    public static void main(String[] args) {
        Solution s = new Puzzle823().new Solution();
//        System.out.println(s.numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
//        System.out.println(s.numFactoredBinaryTrees(new int[]{2, 3, 4, 6, 8, 48}));
        System.out.println(s.numFactoredBinaryTrees(new int[]{18, 3, 6, 2}));
//        System.out.println(s.numFactoredBinaryTrees(new int[]{45, 42, 2, 18, 23, 1170, 12, 41, 40, 9, 47, 24, 33, 28, 10, 32, 29, 17, 46, 11, 759, 37, 6, 26, 21, 49, 31, 14, 19, 8, 13, 7, 27, 22, 3, 36, 34, 38, 39, 30, 43, 15, 4, 16, 35, 25, 20, 44, 5, 48}));

    }

    class Solution {
        public int numFactoredBinaryTrees(int[] a) {
            Arrays.sort(a);
            int len = a.length, max = a[len - 1], mod = 1_000_000_007;

            long[] dp = new long[len];
            Arrays.fill(dp, 1);

            long ans = 0;
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) map.put((long) a[i], i);

            for (int i = 0; i < len; i++) {
                ans = (ans + dp[i]) % mod;
                for (int j = 0; j <= i; j++) {
                    long p = (long) a[i] * a[j];
                    if (p > max) break;
                    Integer idx = map.get(p);
                    if (idx != null) {
                        dp[idx] = (dp[idx] + dp[i] * dp[j] * (i == j ? 1 : 2)) % mod;
                    }
                }
            }
            return (int) ans;
        }
    }

    // PriorityQueue
    class PQSolution {
        public int numFactoredBinaryTrees(int[] a) {
            Arrays.sort(a);
            int len = a.length, max = a[len - 1], mod = 1000000007;

            Map<Integer, Long> map = new HashMap<>();
            for (int n : a) map.put(n, 1L);

            PriorityQueue<C> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.p));
            for (int i = 0; i < len; i++) {
                if (a[i] * a[i] > max) break;
                for (int j = i; j < len; j++) {
                    C c = new C(a[i], a[j]);
                    if (c.p > max) break;
                    if (map.containsKey(c.p)) pq.offer(c);
                }
            }

            while (!pq.isEmpty()) {
                C c = pq.poll();
                int ca = c.a, cb = c.b, cp = c.p;
                if (ca == cb) {
                    long mx = map.get(ca);
                    map.put(cp, map.get(cp) + mx * mx);
                } else {
                    long mx = map.get(ca), my = map.get(cb);
                    map.put(cp, map.get(cp) + mx * my * 2);
                }
            }
            long ans = 0L;
            for (Long k : map.values()) ans += k;
            return (int) (ans % mod);
        }

        class C {
            int a, b, p;

            public C(int a, int b) {
                this.a = a;
                this.b = b;
                p = a * b;
            }
        }
    }
}
