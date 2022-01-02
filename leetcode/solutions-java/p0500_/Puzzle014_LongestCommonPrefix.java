package p0500_;

// Write a function to find the longest common prefix string amongst an array of strings.

/**
 * https://oj.leetcode.com/problems/longest-common-prefix/
 */
public class Puzzle014_LongestCommonPrefix {

    public class Solution {
        private static final String EMPTY = "";

        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0 || EMPTY.equals(strs[0])) {
                return EMPTY;
            }
            if (strs.length == 1) {
                return strs[0];
            }

            StringBuilder result = new StringBuilder();
            char c;

            int len = strs[0].length();

            int i = 0;
            do {
                c = strs[0].charAt(i);
                for (String s : strs) {
                    if (s.length() <= i || (s.charAt(i) != c)) {
                        return result.toString();
                    }
                }
                result.append(c);
            } while (++i < len);
            return result.toString();
        }
    }

    public class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            String result = "";
            int p = Integer.MAX_VALUE;
            int n = strs.length;
            if (n == 1)
                return strs[0];
            String s1, s2;
            int l1, l2;
            for (int i = 0; i < n - 1; i++) {
                s1 = strs[i];
                s2 = strs[i + 1];
                int j = 0;
                l1 = s1.length();
                l2 = s2.length();
                while (j < l1 && j < l2) {
                    if (s1.charAt(j) != s2.charAt(j))
                        break;
                    j++;
                }
                if (j < p) {
                    p = j;
                    result = s1.substring(0, j);
                }
            }
            return result;
        }
    }
}
