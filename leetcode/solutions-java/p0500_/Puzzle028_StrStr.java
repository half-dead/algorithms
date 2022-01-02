package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class Puzzle028_StrStr {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(kmp("abcdefg")));
//        System.out.println(Arrays.toString(kmp("aaaaaaa")));
        System.out.println(Arrays.toString(kmp("abcdabc")));
        System.out.println(Arrays.toString(kmp("aaaaaab")));
    }

    private static int[] kmp(String s) {
        int n = s.length();
        int[] res = new int[n];
        for (int fast = 1, slow = 0; fast < n; ) {
            if (s.charAt(fast) == s.charAt(slow)) {
                res[fast] = slow + 1;
                fast++;
                slow++;
            } else if (slow > 0) {
                slow = res[slow - 1];
            } else {
                fast++;
            }
        }
        return res;
    }

    public class Solution {
        public int strStr(String haystack, String needle) {
            int len1 = haystack.length(), len2 = needle.length();
            if (len2 == 0) return 0;
            if (len2 > len1) return -1;

            int[] kmp = new int[len2];
            for (int i = 1; i < len2; i++) {
                int idx = kmp[i - 1];
                while (idx > 0 && needle.charAt(i) != needle.charAt(idx))
                    idx = kmp[idx - 1];
                if (needle.charAt(idx) == needle.charAt(i))
                    idx++;
                kmp[i] = idx;
            }

            int i1 = 0, i2 = 0;
            while (i1 < len1) {
                while (i1 < len1 && i2 < len2 && haystack.charAt(i1) == needle.charAt(i2)) {
                    i1++;
                    i2++;
                }
                if (i2 == len2) return i1 - i2;
                i1 = i1 - i2 + kmp[i2] + 1;
                i2 = 0;
            }
            return -1;
        }
    }

    // Another KMP implementation
    class Solution1 {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;

            int i = -1, j = 0, m = haystack.length(), n = needle.length();
            int[] next = new int[n];
            if (next.length > 0) next[0] = -1;
            while (j < n - 1) {
                if (i == -1 || needle.charAt(i) == needle.charAt(j))
                    next[++j] = ++i;
                else
                    i = next[i];
            }

            i = 0;
            j = 0;
            while (i < m && j < n) {
                if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else j = next[j];
            }
            return j == n ? i - j : -1;
        }
    }

}
