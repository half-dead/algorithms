package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/valid-arrangement-of-pairs/
 *
 * @author half-dead
 */
public class Puzzle2097 {

    public static void main(String[] args) {
        Solution s = new Puzzle2097().new Solution();
        System.out.println(Arrays.deepToString(s.validArrangement(new int[][]{
                {5, 3}, {2, 3}, {0, 1}, {1, 4}, {0, 5}, {3, 2}, {4, 3}, {3, 0}
        })));
    }

    // post-order dfs, eulerian path
    class Solution {
        int i = 0;

        public int[][] validArrangement(int[][] pairs) {
            Map<Integer, LinkedList<Integer>> g = new HashMap<>();
            Map<Integer, Integer> degrees = new HashMap<>();
            for (int[] p : pairs) {
                g.computeIfAbsent(p[0], x -> new LinkedList<>()).add(p[1]);
                degrees.put(p[0], degrees.getOrDefault(p[0], 0) + 1);
                degrees.put(p[1], degrees.getOrDefault(p[1], 0) - 1);
            }

            // find the start node, there should be at most 1 node whose degree is 1
            int start = -1;
            for (int k : degrees.keySet()) {
                if (degrees.get(k) == 1) {
                    start = k;
                    break;
                }
            }
            // if all node's degrees is 0, then we can choose any of them, the result would be the same
            if (start == -1) {
                start = pairs[0][0];
            }


            int[][] res = new int[pairs.length][2];
            i = pairs.length - 1;
            // post-order dfs
            dfs(start, res, g);
            return res;
        }

        void dfs(int start, int[][] res, Map<Integer, LinkedList<Integer>> g) {
            LinkedList<Integer> nexts = g.get(start);
            if (nexts == null) return;

            while (nexts.size() > 0) {
                int next = nexts.pop();
                dfs(next, res, g);
                res[i--] = new int[]{start, next};
            }
        }
    }

}
