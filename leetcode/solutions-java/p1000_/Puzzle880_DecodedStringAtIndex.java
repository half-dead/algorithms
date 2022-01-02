package p1000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/decoded-string-at-index/
 *
 * @author half-dead
 */
public class Puzzle880_DecodedStringAtIndex {
    public static void main(String[] args) {
        Puzzle880_DecodedStringAtIndex p = new Puzzle880_DecodedStringAtIndex();
        Solution s = p.new Solution();
        System.out.println(s.decodeAtIndex(
                "czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm289thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps",
                768077956
        ));
        System.out.println();
    }

    class Solution {
        public String decodeAtIndex(String s, int k) {
            long len = 0;
            int i = 0;
            for (; len < k; i++) {
                char c = s.charAt(i);
                len = Character.isDigit(c) ? len * (c - '0') : len + 1;
            }
            while (i-- >= 0) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    len /= c - '0';
                    k %= len;
                } else if (k % len == 0) {
                    return String.valueOf(s.charAt(i));
                } else {
                    len--;
                }
            }
            return "";
        }
    }

    class MySolution {
        public String decodeAtIndex(String s, int index) {
            LinkedList<String> q = new LinkedList<>();
            long len = 0, k = index;
            int i = 0;
            StringBuilder builder = new StringBuilder();
            while (len < k && i < s.length()) {
                char c = s.charAt(i++);
                if (c >= 'a' && c <= 'z') {
                    builder.append(c);
                } else {
                    if (builder.length() > 0) {
                        q.push(builder.toString());
                        len += builder.length();
                        builder = new StringBuilder();
                        System.out.println(len);
                    }
                    q.push(String.valueOf(c));
                    len *= c - '0';
                    System.out.println(len);
                }
            }
            if (builder.length() > 0) {
                q.push(builder.toString());
                len += builder.length();
            }
            System.out.println(len);

            while (q.size() > 0) {
                String top = q.pop();
                if (top.charAt(0) < 'a') {
                    len /= top.charAt(0) - '0';
                    k = k % len;
                    if (k == 0) {
                        k = len;
                    }
                } else {
                    if (k == len || len - k < top.length()) {
                        int idx = top.length() - (int) (len - k) - 1;
                        if (idx < 0) {
                            idx += top.length();
                        }
                        return String.valueOf(top.charAt(idx));
                    }
                    len -= top.length();
                }
            }
            return "";
        }
    }
}
