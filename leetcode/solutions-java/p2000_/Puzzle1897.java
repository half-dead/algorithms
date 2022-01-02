package p2000_;

/**
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 *
 * @author half-dead
 */
public class Puzzle1897 {

    class Solution {
        public boolean makeEqual(String[] words) {
            int n = words.length;
            int[] freq = new int[128];
            for (String word : words) for (char c : word.toCharArray()) freq[c]++;
            for (int i = 'a'; i <= 'z'; i++) if (freq[i] % n != 0) return false;
            return true;
        }
    }
}
