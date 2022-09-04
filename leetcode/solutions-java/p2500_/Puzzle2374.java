package p2500_;

/**
 * https://leetcode.com/problems/node-with-highest-edge-score/
 *
 * @author half-dead
 */
public class Puzzle2374 {
    class Solution {
        public int edgeScore(int[] edges) {
            int n = edges.length, res = 0, max = 0;
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                int v = edges[i];
                scores[v] += i;
                if (scores[v] > max || (scores[v] == max && v < res)) {
                    res = v;
                    max = scores[v];
                }
            }
            return res;
        }
    }
}
