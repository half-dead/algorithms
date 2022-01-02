package p0500_;

// Compare two version numbers version1 and version2.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
//
// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//
// Here is an example of version numbers ordering:
//
// 0.1 < 1.1 < 1.2 < 13.37

import java.util.regex.Pattern;

/**
 * https://oj.leetcode.com/problems/compare-version-numbers/
 */
public class Puzzle165_CompareVersionNumbers {

    public class Solution {
        public int compareVersion(String version1, String version2) {
            int len1 = version1.length();
            int len2 = version2.length();
            int sum1, sum2;
            for (int i = 0, j = 0; i < len1 || j < len2; i++, j++) {
                sum1 = 0;
                sum2 = 0;
                while (i < len1 && version1.charAt(i) != '.') {
                    sum1 = sum1 * 10 + (version1.charAt(i++) - '0');
                }
                while (j < len2 && version2.charAt(j) != '.') {
                    sum2 = sum2 * 10 + (version2.charAt(j++) - '0');
                }
                if (sum1 > sum2) {
                    return 1;
                } else if (sum1 < sum2) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public static class StupidSolution {
        private static final Pattern p = Pattern.compile("\\.");

        public int compareVersion(String version1, String version2) {
            String[] s1 = p.split(version1);
            String[] s2 = p.split(version2);
            int maxLength = Math.max(s1.length, s2.length);
            for (int i = 0; i < maxLength; i++) {
                Integer int1 = i >= s1.length ? 0 : Integer.valueOf(s1[i]);
                Integer int2 = i >= s2.length ? 0 : Integer.valueOf(s2[i]);
                if (int1 != int2) {
                    return int1.compareTo(int2);
                }
            }
            return 0;
        }
    }
}
