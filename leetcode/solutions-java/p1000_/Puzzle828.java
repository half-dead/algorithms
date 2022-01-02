package p1000_;

/**
 * https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 *
 * @author half-dead
 */
public class Puzzle828 {

    // one pass dp, O(n) time, O(1) space
    // record the last two occurences of every character
    // for example:
    // given the string AxxAxxA (x means any character except A)
    // the last three occurences of A is [0, 3, 6]
    // the A at index 3 will provide (3-0) * (6-3) uniq chars to the final result.
    class Solution {
        public int uniqueLetterString(String s) {
            int res = 0, n = s.length();

            int[][] dp = new int[26][2];
            for (int i = 0; i < 26; i++) dp[i][0] = dp[i][1] = -1;

            for (int i = 0; i < n; i++) {
                int[] x = dp[s.charAt(i) - 'A'];

                res += (x[1] - x[0]) * (i - x[1]);
                x[0] = x[1];
                x[1] = i;
            }
            for (int[] x : dp) {
                res += (x[1] - x[0]) * (n - x[1]);
            }
            return res;
        }
    }
}
