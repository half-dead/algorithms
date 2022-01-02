package p0500_;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * @author half-dead
 */
public class Puzzle214_ShortestPalindrome {
    public static void main(String[] args) {
        Puzzle214_ShortestPalindrome p = new Puzzle214_ShortestPalindrome();
        Solution s = p.new Solution();
        System.out.println(s.shortestPalindrome("accbccba"));
    }

    // KMP
    class Solution {
        public String shortestPalindrome(String s) {
            char[] chars = new char[s.length() * 2 + 1];
            for (int left = 0, right = chars.length - 1; left < s.length(); left++, right--)
                chars[left] = chars[right] = s.charAt(left);
            int[] kmp = new int[chars.length];
            kmp[0] = 0;
            for (int i = 1; i < chars.length; i++) {
                int idx = kmp[i - 1];
                while (idx > 0 && chars[i] != chars[idx]) {
                    idx = kmp[idx - 1];
                }
                if (chars[i] == chars[idx]) {
                    idx++;
                }
                kmp[i] = idx;
            }
            return new String(chars, s.length() + 1, s.length() - kmp[chars.length - 1]) + s;
        }
    }

    // Optimized Brute Force
    class Solution1 {
        public String shortestPalindrome(String s) {
            int len = s.length();
            if (len < 2) return s;

            char[] reverse = new char[len];
            for (int i = 0, j = len - 1; j >= 0; i++, j--) reverse[i] = s.charAt(j);

            int ri = 0, si = 0;
            while (true) {
                int i1 = si, i2 = ri;
                char c = s.charAt(i1);
                while (i2 < len && reverse[i2] != c) i2++;
                while (i2 < len && s.charAt(i1) == reverse[i2]) {
                    i1++;
                    i2++;
                }
                if (i2 == len) {
                    si = i1;
                    break;
                } else {
                    ri++;
                }
            }
            StringBuilder builder = new StringBuilder();
            int idx = len - 1;
            while (idx >= si) {
                builder.append(s.charAt(idx--));
            }
            return builder.append(s).toString();
        }
    }

    // recursive 1ms
    class Solution2 {
        public String shortestPalindrome(String s) {
            int j = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    j += 1;
                }
            }
            if (j == s.length()) {
                return s;
            }
            String suffix = s.substring(j);
            return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
        }
    }
}
