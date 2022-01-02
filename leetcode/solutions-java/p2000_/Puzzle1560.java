package p2000_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
 *
 * @author half-dead
 */
public class Puzzle1560 {

    public static void main(String[] args) {
        Solution s = new Puzzle1560().new Solution();
        System.out.println(s.mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
    }

    // only start and end matters, the rest are useless
    class Solution {
        public List<Integer> mostVisited(int n, int[] rounds) {
            int start = rounds[0], end = rounds[rounds.length - 1];
            List<Integer> res = new ArrayList<>();
            if (start == end) {
                res.add(start);
            } else if (start < end) {
                for (int i = start; i <= end; i++) res.add(i);
            } else {
                for (int i = 1; i <= end; i++) res.add(i);
                for (int i = start; i <= n; i++) res.add(i);
            }
            return res;
        }
    }

    // simulation
    class Solution1 {
        public List<Integer> mostVisited(int n, int[] rounds) {
            int[] sec = new int[101];
            for (int i = 1; i < rounds.length; i++) {
                int start = rounds[i - 1], end = rounds[i];
                if (start > end) end += n;
                for (int j = start; j < end; j++) {
                    sec[j <= n ? j : (j % n)]++;
                }
            }
            sec[rounds[rounds.length - 1]]++;
            int max = 0;
            for (int f : sec) max = Math.max(max, f);

            List<Integer> res = new ArrayList<>();
            for (int i = 1; i <= 100; i++) if (sec[i] == max) res.add(i);
            return res;
        }
    }
}
