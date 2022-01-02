/*
https://leetcode.com/problems/buddy-strings/description/

Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

Example 1:
    Input: A = "ab", B = "ba"
    Output: true
Example 2:
    Input: A = "ab", B = "ab"
    Output: false
Example 3:
    Input: A = "aa", B = "aa"
    Output: true
Example 4:
    Input: A = "aaaaaaabc", B = "aaaaaaacb"
    Output: true
Example 5:
    Input: A = "", B = "aa"
    Output: false

Note:
    0 <= A.length <= 20000
    0 <= B.length <= 20000
    A and B consist only of lowercase letters.
 */

package p1000_;

/**
 * @author half-dead
 */
public class Puzzle859_BuddyStrings {
    class Solution {
        public boolean buddyStrings(String A, String B) {
            int lenA = A.length(), lenB = B.length();
            if (lenA == lenB) {
                int count = 0;
                int[] countsA = new int[26], countsB = new int[26];
                for (int i = 0; i < lenA; i++) {
                    if (A.charAt(i) != B.charAt(i)) {
                        count++;
                    }
                    countsA[(A.charAt(i) - 'a')]++;
                    countsB[(B.charAt(i) - 'a')]++;
                }
                if (count == 0) {
                    for (int i : countsA) {
                        if (i > 1) {
                            return true;
                        }
                    }
                } else if (count == 2) {
                    int same = 0;
                    for (int i = 0; i < 26; i++) {
                        if (countsA[i] == countsB[i]) {
                            same++;
                        }
                    }
                    return same == 26;
                }
            }
            return false;
        }
    }
}
