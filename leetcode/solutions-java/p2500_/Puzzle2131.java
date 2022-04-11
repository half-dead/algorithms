package p2500_;

/**
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
 *
 * @author half-dead
 */
public class Puzzle2131 {

    class Solution {
        public int longestPalindrome(String[] words) {
            int res = 0;
            int[][] freq = new int[26][26];
            for (String w : words) {
                int a = w.charAt(0) - 'a', b = w.charAt(1) - 'a';
                if (freq[a][b] > 0) {
                    freq[a][b]--;
                    res += 4;
                } else {
                    freq[b][a]++;
                }
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i][i] > 0) {
                    res += 2;
                    break;
                }
            }
            return res;
        }
    }
}
