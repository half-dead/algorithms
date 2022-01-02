package p0500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/decode-string/
 *
 * @author half-dead
 */
public class Puzzle394_DecodeString {

    public static void main(String[] args) {
        Puzzle394_DecodeString p = new Puzzle394_DecodeString();
        Solution s = p.new Solution();
        System.out.println(s.decodeString("3[a]2[bc]"));        // aaabcbc
        System.out.println(s.decodeString("3[a2[c]]"));         // accaccacc
        System.out.println(s.decodeString("2[abc]3[cd]ef"));    // abcabccdcdcdef
    }

    class Solution {
        public String decodeString(String s) {
            LinkedList<String> q = new LinkedList<>();
            int n = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    if (builder.length() > 0) {
                        q.push(builder.toString());
                        builder = new StringBuilder();
                    }
                    n *= 10;
                    n += c - '0';
                } else if (c == '[') {
                    q.push(String.valueOf(n));
                    n = 0;
                } else if (c == ']') {
                    while (Character.isLetter(q.peek().charAt(0))) {
                        builder.insert(0, q.pop());
                    }
                    StringBuilder another = new StringBuilder();
                    int repeat = Integer.valueOf(q.pop());
                    while (repeat-- > 0) {
                        another.append(builder);
                    }
                    builder = another;
                } else {
                    builder.append(c);
                }
            }
            while (q.size() > 0) {
                builder.insert(0, q.pop());
            }
            return builder.toString();
        }
    }
}
