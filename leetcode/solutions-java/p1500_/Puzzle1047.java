package p1500_;

/**
 * Remove All Adjacent Duplicates In String
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * @author half-dead
 */
public class Puzzle1047 {
    public static void main(String[] args) {
        Solution s = new Puzzle1047().new Solution();
        System.out.println(s.removeDuplicates("abbaca"));
    }

    class Solution {
        public String removeDuplicates(String s) {
            char[] chars = s.toCharArray();
            int end = -1;
            for (int i = 0; i < chars.length; i++) {
                if (end >= 0 && chars[i] == chars[end]) end--;
                else chars[++end] = chars[i];
            }
            return new String(chars, 0, end + 1);
        }
    }

    class StringBuilderSolution {
        public String removeDuplicates(String s) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0, slen = s.length(); i < slen; i++) {
                int len = builder.length();
                char c = s.charAt(i);
                if (len > 0 && c == builder.charAt(len - 1)) builder.deleteCharAt(len - 1);
                else builder.append(c);
            }
            return builder.toString();
        }
    }
}
