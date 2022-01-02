package p2000_;

/**
 * https://leetcode.com/problems/reverse-prefix-of-word/
 *
 * @author half-dead
 */
public class Puzzle2000 {

    class Solution {
        public String reversePrefix(String word, char ch) {
            int pos = word.indexOf(ch);
            if (pos <= 0) return word;

            char[] cs = word.toCharArray();
            int lo = 0, hi = pos;
            while (lo < hi) {
                char temp = cs[lo];
                cs[lo] = cs[hi];
                cs[hi] = temp;
                lo++;
                hi--;
            }
            return new String(cs);
        }
    }
}
