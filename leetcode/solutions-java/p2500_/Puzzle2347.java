package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-poker-hand/
 *
 * @author half-dead
 */
public class Puzzle2347 {
    class Solution {
        public String bestHand(int[] ranks, char[] suits) {
            Arrays.sort(suits);
            if (suits[0] == suits[4]) return "Flush";

            int[] freq = new int[14];
            int max = 1;
            for (int r : ranks) {
                if (++freq[r] > max) {
                    max = freq[r];
                }
            }
            return max >= 3 ? "Three of a Kind" : (max == 2 ? "Pair" : "High Card");
        }
    }
}
