package p2500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 *
 * @author half-dead
 */
public class Puzzle2225 {

    // counting
    class Solution {

        public List<List<Integer>> findWinners(int[][] matches) {
            int[] cnts = new int[100001], losts = new int[100001];
            for (int[] m : matches) {
                cnts[m[0]]++;
                cnts[m[1]]++;
                losts[m[1]]++;
            }
            List<Integer> winners = new ArrayList<>();
            List<Integer> losers = new ArrayList<>();
            for (int i = 1; i <= 100000; i++) {
                if (cnts[i] == 0) continue;
                if (losts[i] == 0) winners.add(i);
                else if (losts[i] == 1) losers.add(i);
            }
            return Arrays.asList(winners, losers);
        }
    }
}
