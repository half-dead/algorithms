package p1000_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/freedom-trail/
 *
 * @author half-dead
 */
public class Puzzle514 {

    // BFS + Bottom-Up DP
    class Solution {
        public int findRotateSteps(String ring, String key) {
            int n = ring.length(), m = key.length(), ans = Integer.MAX_VALUE;

            Map<Character, List<Integer>> group = new HashMap<>();
            for (int i = 0; i < n; i++)
                group.computeIfAbsent(ring.charAt(i), x -> new ArrayList<>()).add(i);


            List<int[]> from = new ArrayList<>(), to;
            // [total_steps, current_index]
            from.add(new int[]{0, 0});

            for (int i = 0; i < m; i++) {
                List<Integer> candidates = group.get(key.charAt(i));
                to = new ArrayList<>(candidates.size());

                for (int cand : candidates) {
                    int min = Integer.MAX_VALUE;
                    for (int[] prev : from) {
                        int d = Math.abs(prev[1] - cand);
                        min = Math.min(min, prev[0] + Math.min(d, n - d));
                    }
                    to.add(new int[]{min, cand});
                }
                from = to;
            }

            for (int[] x : from) ans = Math.min(ans, x[0]);
            return ans + m;
        }
    }
}
