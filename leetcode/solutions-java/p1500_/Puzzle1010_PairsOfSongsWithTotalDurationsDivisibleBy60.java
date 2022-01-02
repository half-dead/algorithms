package p1500_;

/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * @author half-dead
 */
public class Puzzle1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int[] map = new int[60];
            for (int t : time) map[t % 60]++;

            int res = map[0] * (map[0] - 1) / 2 + map[30] * (map[30] - 1) / 2;
            for (int i = 1; i < 30; i++) res += map[i] * map[60 - i];
            return res;
        }
    }

    class NeatSolution {
        public int numPairsDivisibleBy60(int[] time) {
            int[] count = new int[60];
            int res = 0;
            for (int t : time) {
                int idx = t % 60;
                res += idx == 0 ? count[0] : count[60 - idx];
                count[idx]++;
            }
            return res;
        }
    }
}
