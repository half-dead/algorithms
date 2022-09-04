package p2500_;

/**
 * https://leetcode.com/problems/rearrange-characters-to-make-target-string/
 *
 * @author half-dead
 */
public class Puzzle2287 {

    class Solution {
        public int rearrangeCharacters(String s, String target) {
            int[] a = new int[26], b = new int[26];
            for (char c : s.toCharArray()) a[c - 'a']++;
            for (char c : target.toCharArray()) b[c - 'a']++;

            int res = s.length() / target.length();
            for (int i = 0; i < 26; i++) {
                if (b[i] != 0)
                    res = Math.min(res, a[i] / b[i]);
            }
            return res;
        }
    }
}
