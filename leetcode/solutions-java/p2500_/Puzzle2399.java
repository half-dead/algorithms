package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/check-distances-between-same-letters/
 *
 * @author half-dead
 */
public class Puzzle2399 {
    class Solution {
        public boolean checkDistances(String s, int[] distance) {
            int[] pos = new int[26];
            Arrays.fill(pos, -1);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int j = c - 'a';
                if (pos[j] == -1) {
                    pos[j] = i;
                } else if (distance[j] != i - pos[j] - 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
