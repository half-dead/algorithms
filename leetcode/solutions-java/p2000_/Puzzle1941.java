package p2000_;

/**
 * https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
 *
 * @author half-dead
 */
public class Puzzle1941 {

    class Solution {
        public boolean areOccurrencesEqual(String s) {
            int[] freq = new int[128];
            int uniq = 0;
            for (int i = 0; i < s.length(); i++) {
                if (freq[s.charAt(i)]++ == 0) uniq++;
            }
            int avg = s.length() / uniq;
            for (int f : freq) if (f != 0 && f != avg) return false;
            return true;
        }
    }
}
