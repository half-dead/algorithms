package p1000_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 *
 * @author half-dead
 */
public class Puzzle784_LetterCasePermutation {

    public static void main(String[] args) {
        Solution s = new Puzzle784_LetterCasePermutation().new Solution();
        System.out.println(s.letterCasePermutation("a1b2"));
        System.out.println(s.letterCasePermutation("123456"));
        System.out.println(s.letterCasePermutation("abcdef"));
    }

    class Solution {
        public List<String> letterCasePermutation(String s) {
            List<String> list = new ArrayList<>();
            dfs(s.toCharArray(), list, 0);
            return list;
        }

        private boolean dfs(char[] chars, List<String> list, int i) {
            if (i == chars.length) return list.add(new String(chars));

            char c = chars[i];
            if (c < '0' || c > '9') {
                chars[i] = Character.toLowerCase(c);
                dfs(chars, list, i + 1);
                chars[i] = Character.toUpperCase(c);
            }
            return dfs(chars, list, i + 1);
        }
    }

    class Solution1 {
        public List<String> letterCasePermutation(String s) {
            if (s.length() == 0) return Collections.singletonList("");

            List<String> list = new ArrayList<>();
            char c = s.charAt(0);
            List<String> rest = letterCasePermutation(s.substring(1));
            for (String r : rest) {
                if (c >= '0' && c <= '9') {
                    list.add(c + r);
                } else {
                    list.add(Character.toUpperCase(c) + r);
                    list.add(Character.toLowerCase(c) + r);
                }
            }
            return list;
        }
    }
}
