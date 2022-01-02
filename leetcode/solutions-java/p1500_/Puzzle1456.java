package p1500_;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 *
 * @author half-dead
 */
public class Puzzle1456 {
    class Solution {
        public int maxVowels(String s, int k) {
            char[] chars = s.toCharArray();
            int max = 0;
            for (int i = 0, cnt = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt++;
                if (i >= k) {
                    char p = chars[i - k];
                    if (p == 'a' || p == 'e' || p == 'i' || p == 'o' || p == 'u') cnt--;
                }
                max = Math.max(max, cnt);
            }
            return max;
        }
    }
}
