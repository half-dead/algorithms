/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Given a string, find the length of the longest substring without repeating characters.

Examples:
  Given "abcabcbb", the answer is "abc", which the length is 3.
  Given "bbbbb", the answer is "b", with the length of 1.
  Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
        "pwke" is a subsequence and not a substring.
 */

package p0500_;

public class Puzzle003_LengthOfLongestSubstring {
    public static void main(String[] args) {
        Puzzle003_LengthOfLongestSubstring p = new Puzzle003_LengthOfLongestSubstring();
        Solution solution = p.new Solution();
        int aab = solution.lengthOfLongestSubstring("cdd");
        System.out.println(aab);
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] cs = s.toCharArray();
            int[] cnt = new int[128];
            int start = 0, end = 0, max = 0;
            while (end < cs.length) {
                cnt[cs[end]]++;
                while (cnt[cs[end]] >= 2) {
                    cnt[cs[start++]]--;
                }

                if (end - start + 1 > max) {
                    max = end - start + 1;
                }
                end++;
            }
            return max;
        }
    }

    public class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            char[] cs = s.toCharArray();
            int n = cs.length, ans = 0;
            int[] index = new int[128];
            for (int left = 0, right = 0; right < n; right++) {
                left = Math.max(index[cs[right]], left);
                ans = Math.max(ans, right - left + 1);
                index[cs[right]] = right + 1;
            }
            return ans;
        }
    }
}
