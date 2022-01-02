package p2500_;

/**
 * https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/
 *
 * @author half-dead
 */
public class Puzzle2068 {

    class Solution {
        public boolean checkAlmostEquivalent(String word1, String word2) {
            int[] cnt = new int[128];
            for (char c : word1.toCharArray()) cnt[c]++;
            for (char c : word2.toCharArray()) cnt[c]--;
            for (int i = 'a'; i <= 'z'; i++) {
                if (Math.abs(cnt[i]) > 3) return false;
            }
            return true;
        }
    }
}
