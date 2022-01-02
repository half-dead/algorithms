package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/loud-and-rich/
 *
 * @author half-dead
 */
public class Puzzle851 {

    class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;

            // pre-compute graph
            Map<Integer, Set<Integer>> g = new HashMap<>();
            for (int[] r : richer) g.computeIfAbsent(r[1], x -> new HashSet<>()).add(r[0]);

            // find the smallest quietness recursively
            int[] res = new int[n];
            Arrays.fill(res, n);
            for (int i = 0; i < n; i++) find(g, quiet, i, n, res);

            // convert quietness to index
            Map<Integer, Integer> qmap = new HashMap<>(n);
            for (int i = 0; i < n; i++) qmap.put(quiet[i], i);
            for (int i = 0; i < n; i++) res[i] = qmap.get(res[i]);

            return res;
        }

        int find(Map<Integer, Set<Integer>> g, int[] q, int i, int n, int[] res) {
            if (res[i] < n) return res[i];
            res[i] = q[i];

            Set<Integer> richer = g.get(i);
            if (richer != null) {
                for (int j : richer) {
                    res[i] = Math.min(res[i], find(g, q, j, n, res));
                }
            }
            return res[i];
        }
    }
}
