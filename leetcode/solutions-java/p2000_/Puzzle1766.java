package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/tree-of-coprimes/
 *
 * @author half-dead
 */
public class Puzzle1766 {

    class Solution {
        Map<Integer, Set<Integer>> g, coprimes;
        boolean[] visited;
        int[] res, nums;
        int[][] state = new int[51][2];

        public int[] getCoprimes(int[] nums, int[][] edges) {
            this.nums = nums;

            int n = nums.length;
            g = new HashMap<>(n);
            for (int i = 0; i < n; i++) g.put(i, new HashSet<>());
            for (int[] e : edges) {
                g.get(e[0]).add(e[1]);
                g.get(e[1]).add(e[0]);
            }

            coprimes = prepare();
            visited = new boolean[n];
            res = new int[n];
            Arrays.fill(state, new int[]{-1, -1});

            dfs(0, 0);
            return res;
        }

        void dfs(int node, int depth) {
            if (visited[node]) return;
            visited[node] = true;

            // find closest coprime index
            int val = nums[node], closest = -1, index = -1;
            for (int cp : coprimes.get(val)) {
                if (state[cp][0] != -1 && state[cp][1] > closest) {
                    closest = state[cp][1];
                    index = state[cp][0];
                }
            }
            res[node] = index;

            // backtracking dfs
            int[] prev = state[val];
            state[val] = new int[]{node, depth};
            for (int next : g.get(node)) {
                if (visited[next]) continue;

                dfs(next, depth + 1);
            }
            state[val] = prev;
        }

        Map<Integer, Set<Integer>> prepare() {
            Map<Integer, Set<Integer>> res = new HashMap<>(50);
            for (int i = 1; i <= 50; i++) {
                res.put(i, new HashSet<>());
            }
            for (int i = 1; i <= 50; i++) {
                for (int j = i; j <= 50; j++) {
                    if (gcd(i, j) == 1) {
                        res.get(i).add(j);
                        res.get(j).add(i);
                    }
                }
            }
            return res;
        }

        int gcd(int x, int y) {
            if (x == y) return x;
            if (x == 0) return y;
            return gcd(y % x, x);
        }
    }
}
