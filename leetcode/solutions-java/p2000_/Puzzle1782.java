package p2000_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-pairs-of-nodes/
 *
 * @author half-dead
 */
public class Puzzle1782 {

    // sort + two-pointers
    class Solution {
        public int[] countPairs(int n, int[][] edges, int[] queries) {

            int[] cnts = new int[n + 1], sorted = new int[n + 1];
            Map<Integer, Map<Integer, Integer>> conns = new HashMap<>();
            for (int[] e : edges) {
                sorted[e[0]] = ++cnts[e[0]];
                sorted[e[1]] = ++cnts[e[1]];

                int min = Math.min(e[0], e[1]), max = Math.max(e[0], e[1]);
                Map<Integer, Integer> slot = conns.computeIfAbsent(min, x -> new HashMap<>());
                slot.put(max, slot.getOrDefault(max, 0) + 1);
            }

            Arrays.sort(sorted);

            int m = queries.length;
            int[] res = new int[m];
            for (int i = 0; i < m; i++) {
                int q = queries[i];
                for (int lo = 1, hi = n; lo < hi; ) {
                    if (q < sorted[lo] + sorted[hi]) {
                        res[i] += (hi--) - lo;
                    } else {
                        lo++;
                    }
                }

                for (int from = 1; from < n; from++) {
                    Map<Integer, Integer> slot = conns.get(from);
                    if (slot == null) continue;

                    for (int to : slot.keySet()) {
                        int repeats = slot.get(to);
                        if (q < cnts[from] + cnts[to] && q >= cnts[from] + cnts[to] - repeats) {
                            res[i]--;
                        }
                    }
                }
            }
            return res;
        }
    }


}
