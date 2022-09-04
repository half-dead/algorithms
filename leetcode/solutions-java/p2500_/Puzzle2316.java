package p2500_;

import util.UnionFind;

import java.util.*;

/**
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 *
 * @author half-dead
 */
public class Puzzle2316 {

    public static void main(String[] args) {
        Solution s = new Puzzle2316().new Solution();
        System.out.println(s.countPairs(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }

    class Solution {
        public long countPairs(int n, int[][] edges) {
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int pi = uf.find(i);
                int cnt = uf.size(pi);
                map.put(pi, cnt);
            }

            Map<Integer, Integer> gm = new HashMap<>();
            for (int cnt : map.values()) {
                gm.put(cnt, gm.getOrDefault(cnt, 0) + 1);
            }

            long res = 0L;
            for (int k : gm.keySet()) {
                int v = gm.get(k);
                res += (long) k * (n - k) * v;
            }

            return res >> 1;
        }
    }

}
