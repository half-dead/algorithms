package p2000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-square-sum-triples/
 *
 * @author half-dead
 */
public class Puzzle1925 {

    class Solution {
        public int countTriples(int n) {
            int[] sq = new int[n + 1];
            Set<Integer> set = new HashSet<>(n);
            for (int i = 1; i <= n; i++) {
                sq[i] = i * i;
                set.add(sq[i]);
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (set.contains(sq[i] + sq[j])) res += 2;
                }
            }
            return res;
        }
    }
}
