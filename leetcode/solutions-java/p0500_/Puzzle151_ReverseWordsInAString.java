package p0500_;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * @author half-dead
 */
public class Puzzle151_ReverseWordsInAString {

    public static void main(String[] args) {
        Puzzle151_ReverseWordsInAString p = new Puzzle151_ReverseWordsInAString();
        Solution s = p.new Solution();
        String r = s.reverseWords(" 1");
        System.out.println(r);
    }

    public class Solution {
        public String reverseWords(String s) {
            StringBuilder builder = new StringBuilder();
            int i = s.length() - 1;
            while (i >= 0) {
                while (i >= 0 && s.charAt(i) == ' ') {
                    i--;
                }
                int k = 0;
                while (i >= 0 && s.charAt(i) != ' ') {
                    k++;
                    i--;
                }
                if (k > 0) {
                    if (builder.length() > 0) {
                        builder.append(' ');
                    }
                    builder.append(s, i + 1, i + k + 1);
                }
            }
            return builder.toString();
        }
    }
}
