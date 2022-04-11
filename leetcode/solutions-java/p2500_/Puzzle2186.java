package p2500_;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
 *
 * @author half-dead
 */
public class Puzzle2186 {

    // freq count
    class Solution {
        public int minSteps(String s, String t) {
            int[] f = new int[26];
            for (char c : s.toCharArray()) f[c - 'a']++;
            for (char c : t.toCharArray()) f[c - 'a']--;

            int res = 0;
            for (int i = 0; i < 26; i++) res += Math.abs(f[i]);
            return res;
        }
    }
}
