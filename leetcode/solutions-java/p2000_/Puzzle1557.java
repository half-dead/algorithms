package p2000_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 *
 * @author half-dead
 */
public class Puzzle1557 {

    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            boolean[] b = new boolean[n];
            for (List<Integer> edge : edges) b[edge.get(1)] = true;

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) if (!b[i]) res.add(i);
            return res;
        }
    }
}
