package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 *
 * @author half-dead
 */
public class Puzzle1647 {

    class Solution {
        public int minDeletions(String s) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;
            Arrays.sort(freq);

            int max = freq[25], res = 0;
            for (int i = 24; i >= 0; i--) {
                if (freq[i] == 0) break;

                if (freq[i] >= max) {
                    res += freq[i] - max + 1;
                    max = Math.max(1, max - 1);
                } else {
                    max = freq[i];
                }

            }
            return res;
        }
    }
}
