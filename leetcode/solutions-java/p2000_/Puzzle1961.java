package p2000_;

/**
 * https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/submissions/
 *
 * @author half-dead
 */
public class Puzzle1961 {

    public static void main(String[] args) {
        Solution s = new Puzzle1961().new Solution();
        System.out.println(s.isPrefixString("z", new String[]{"z"}));
    }

    class Solution {
        public boolean isPrefixString(String s, String[] words) {
            int i = 0;
            for (String word : words) {
                int len = word.length();
                if (i + len > s.length()) break;
                if (!s.substring(i, i + len).equals(word)) break;

                i += len;
                if (i == s.length()) return true;
            }
            return false;
        }
    }
}
