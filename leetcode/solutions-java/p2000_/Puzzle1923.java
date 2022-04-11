package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-common-subpath/
 *
 * @author half-dead
 */
public class Puzzle1923 {

    public static void main(String[] args) {
        Solution s = new Puzzle1923().new Solution();
        System.out.println(s.longestCommonSubpath(5, new int[][]{
                {0, 1, 2, 3, 4},
                {2, 3, 4},
                {4, 0, 1, 2, 3}
        }));
    }


    // this code is accepted(1090ms) with the hash collision checking codes commented out.
    // but will get TLE if we do hash collision checking
    // find another time to learn about suffix array.
    class Solution {
        public int longestCommonSubpath(int n, int[][] paths) {
            int lo = 0, hi = paths[0].length;
            for (int[] p : paths) hi = Math.min(hi, p.length);

            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                if (validate(paths, mid, n)) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            return lo;
        }

        boolean validate(int[][] paths, int k, int n) {
            int m = paths.length;
            Map<Long, List<Integer>> base = hashes(paths[0], k, n);

            for (int i = 1; i < m; i++) {
                Map<Long, List<Integer>> curr = hashes(paths[i], k, n);
                Map<Long, List<Integer>> next = new HashMap<>();
                for (long rh : base.keySet()) {
                    if (curr.containsKey(rh)) {
                        List<Integer> alist = base.get(rh);
                        List<Integer> blist = curr.get(rh);
                        for (int p : alist) {
                            for (int q : blist) {
                                if (check(paths[0], p, paths[i], q, k)) {
                                    next.computeIfAbsent(rh, y -> new ArrayList<>()).add(p);
                                }
                            }
                        }
                    }
                }
                if (next.size() == 0) return false;
                base = next;
            }
            return true;
        }

        Map<Long, List<Integer>> hashes(int[] path, int k, int n) {
            Map<Long, List<Integer>> res = new HashMap<>();
            long hash = 0L, mod = 100000000019L, p = 1L;
            for (int i = 0; i < k; i++) {
                p = (p * n) % mod;
            }

            for (int i = 0; i < path.length; i++) {
                hash = (hash * n + path[i]) % mod;
                if (i >= k - 1) {
                    if (i >= k) {
                        hash = (hash - p * path[i - k]) % mod;
                        hash = (hash + mod) % mod;
                    }
                    res.computeIfAbsent(hash, x -> new ArrayList<>()).add(i - k + 1);
                }
            }
            return res;
        }

        boolean check(int[] a, int i, int[] b, int j, int k) {
            while (k-- > 0) {
                if (a[i++] != b[j++]) return false;
            }
            return true;
        }
    }
}
