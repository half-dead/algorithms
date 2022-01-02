package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * @author half-dead
 */
public class Puzzle395 {

    public static void main(String[] args) {
        Solution s = new Puzzle395().new Solution();
        System.out.println(s.longestSubstring("aaabbbcdefcdefgggggggggggggggcde", 3));
    }

    /**
     * Base idea
     * <pre>
     * count apperances of every letter, we have 2 cases
     *      1. all letters's apperances >= k, just return the length of s
     *      2. some letters's apperances < k, we split s at every apperance of those letters,
     *         and do a recursive call on every substring
     * </pre>
     */
    class Solution {
        public int longestSubstring(String s, int k) {
            int[] cnt = new int[26], tmp = new int[26];
            char[] chars = s.toCharArray();
            for (char c : chars) cnt[c - 'a']++;

            int max = 0, from = 0;
            for (int i = 0; i < chars.length; i++) {
                if (cnt[chars[i] - 'a'] < k) {
                    if (i >= from + k) {
                        max = Math.max(max, longestSubstring(s.substring(from, i), k));
                    }
                    from = i + 1;
                    Arrays.fill(tmp, 0);
                } else {
                    tmp[chars[i] - 'a']++;
                }
            }
            if (from == 0) max = Math.max(max, count(tmp, k));
            else if (from < chars.length) max = Math.max(max, longestSubstring(s.substring(from), k));
            return max;
        }

        int count(int[] arr, int k) {
            int res = 0;
            for (int n : arr) {
                if (n >= k) res += n;
                else if (n > 0) return 0;
            }
            return res;
        }
    }
}
