/*
https://leetcode.com/problems/is-subsequence/description/

Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t.
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters.
(ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
    s = "abc", t = "ahbgdc"
    Return true.
Example 2:
    s = "axc", t = "ahbgdc"
    Return false.

Follow up:
    If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check
    one by one to see if T has its subsequence. In this scenario, how would you change your code?
 */

package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle392_IsSubsequence {

    public static void main(String[] args) {
        Solution s = new Puzzle392_IsSubsequence().new Solution();
        boolean b = s.isSubsequence("acb", "ahbgdc");
        System.out.println(b);
    }

    class Solution {
        public boolean isSubsequence(String s, String t) {
            char[] chars = s.toCharArray();
            for (int i = 0, pos = 0; i < chars.length; i++, pos++) {
                pos = t.indexOf(chars[i], pos);
                if (pos == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    class StupidSolution {
        public boolean isSubsequence(String s, String t) {
            ArrayList[] dict = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                dict[i] = new ArrayList<Integer>();
            }

            char[] chars = t.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                dict[chars[i] - 'a'].add(i);
            }

            char[] schars = s.toCharArray();
            int begin = -1;
            for (int i = 0; i < schars.length; i++) {
                ArrayList indexes = dict[schars[i] - 'a'];
                int ni = findFirstGreater(indexes, begin);
                if (ni == -1) {
                    return false;
                }
                begin = ni;
            }
            return true;
        }

        public int findFirstGreater(List<Integer> list, int index) {
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                Integer mi = list.get(mid);
                if (mi <= index) {
                    left = mid + 1;
                } else {
                    if (mid == 0 || list.get(mid - 1) <= index) {
                        return mi;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
