package p2000_;

/**
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 *
 * @author half-dead
 */
public class Puzzle1930 {

    class Solution {
        public int countPalindromicSubsequence(String s) {
            int res = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                int first = s.indexOf(c), last = s.lastIndexOf(c), uniq = 0;
                if (last > first && first >= 0) {
                    int[] cnt = new int[128];
                    for (int i = first + 1; i < last; i++) {
                        if (cnt[s.charAt(i)]++ == 0)
                            if (++uniq == 26)
                                break;
                    }
                    res += uniq;
                }
            }
            return res;
        }
    }
}
