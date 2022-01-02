package p2000_;

/**
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 *
 * @author half-dead
 */
public class Puzzle1663 {

    public static void main(String[] args) {
        Solution s = new Puzzle1663().new Solution();
        System.out.println(s.getSmallestString(3, 4));
        System.out.println(s.getSmallestString(3, 27));
        System.out.println(s.getSmallestString(5, 73));
    }

    class Solution {
        public String getSmallestString(int n, int k) {
            char[] chars = new char[n];
            int i = n - 1;
            for (; i >= 0; i--) {
                if (k >= i + 26) {
                    chars[i] = 'z';
                    k -= 26;
                } else if (k > i) {
                    chars[i] = (char) ('a' + (k - i - 1));
                    break;
                }
            }
            for (i -= 1; i >= 0; i--) {
                chars[i] = 'a';
            }
            return new String(chars);
        }
    }
}
