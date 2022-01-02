package p2000_;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 *
 * @author half-dead
 */
public class Puzzle1963 {

    class Solution {
        public int minSwaps(String s) {
            int i = 0, j = s.length() - 1, open = 0, res = 0;
            char[] cs = s.toCharArray();
            while (i < j) {
                if (cs[i++] == '[') open++;
                else open--;
                if (open < 0) {
                    while (cs[j] != '[') j--;
                    open = 1;
                    res++;
                }
            }
            return res;
        }
    }
}
