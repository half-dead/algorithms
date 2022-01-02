package p1500_;

/**
 * https://leetcode.com/problems/increasing-decreasing-string/
 *
 * @author half-dead
 */
public class Puzzle1370_IncreasingDecreasingString {
    class Solution {
        public String sortString(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            int len = s.length();
            StringBuilder result = new StringBuilder(s.length());
            while (len > 0) {
                for (int i = 0; i < count.length; i++) {
                    if (count[i]-- > 0) {
                        result.append((char) ('a' + i));
                        len--;
                    }
                }
                for (int i = 25; i >= 0; i--) {
                    if (count[i]-- > 0) {
                        result.append((char) ('a' + i));
                        len--;
                    }
                }
            }
            return result.toString();
        }
    }
}
