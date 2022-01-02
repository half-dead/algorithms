package p1500_;

/**
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 *
 * @author half-dead
 */
public class Puzzle1003 {
    public static void main(String[] args) {
        Solution s = new Puzzle1003().new Solution();
        System.out.println(s.isValid("aabbcc"));
    }

    class Solution {
        public boolean isValid(String s) {
            char[] cs = s.toCharArray();
            int a = 0, b = 0, c = 0;
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == 'a') a++;
                else if (cs[i] == 'b') b++;
                else c++;

                if (i == cs.length - 1) break;
                if (cs[i] == 'a' && cs[i + 1] == 'c') return false;
                if (cs[i] == 'b' && cs[i + 1] == 'b') return false;
            }
            return a == b && b == c && cs[0] == 'a' && cs[cs.length - 1] == 'c';
        }
    }
}
