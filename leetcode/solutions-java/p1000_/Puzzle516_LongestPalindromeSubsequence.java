package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * @author half-dead
 */
public class Puzzle516_LongestPalindromeSubsequence {

    public static void main(String[] args) {
        Solution s = new Puzzle516_LongestPalindromeSubsequence().new Solution();
        Solution1 s1 = new Puzzle516_LongestPalindromeSubsequence().new Solution1();
//        System.out.println(s.longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
        System.out.println(s.longestPalindromeSubseq("abbcdefgfedca"));
        System.out.println(s1.longestPalindromeSubseq("abbcdefgfedca"));
    }

    // O(N^2) space
    public class Solution {
        public int longestPalindromeSubseq(String s) {
            int len = s.length();
            int[][] dp = new int[len][len];
            char[] chars = s.toCharArray();
            for (int i = len - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < len; j++) {
                    if (chars[i] == chars[j]) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
    }

    // O(N) space
    class Solution1 {
        public int longestPalindromeSubseq(String s) {
            char[] chars = s.toCharArray();
            int len = s.length();
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            for (int i = 0; i < len; i++) {
                int curLong = 0;
                for (int j = i - 1; j >= 0; j--) {
                    int temp = dp[j];
                    if (chars[j] == chars[i]) {
                        dp[j] = curLong + 2;
                    }
                    curLong = Math.max(curLong, temp);
                }
            }
            int max = 0;
            for (int n : dp) {
                if (max < n) {
                    max = n;
                }
            }
            return max;
        }
    }
}
