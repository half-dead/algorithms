package p2500_;

/**
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 *
 * @author half-dead
 */
public class Puzzle2108 {

    class Solution {
        public String firstPalindrome(String[] words) {
            for (String w : words) {
                int n = w.length();
                boolean palin = true;
                for (int i = 0, j = n - 1; i < j; i++, j--) {
                    if (w.charAt(i) != w.charAt(j)) {
                        palin = false;
                        break;
                    }
                }
                if (palin) return w;
            }
            return "";
        }
    }
}
