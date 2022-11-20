package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
 *
 * @author half-dead
 */
public class Puzzle2410 {
    // greedy
    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);

            int i = 0, j = 0, m = players.length, n = trainers.length;
            int cnt = 0;
            while (i < m && j < n) {
                if (players[i] <= trainers[j]) {
                    i++;
                    j++;
                    cnt++;
                } else j++;
            }
            return cnt;
        }
    }
}
