package p1000_;

/**
 * https://leetcode.com/problems/strange-printer/
 *
 * @author half-dead
 */
public class Puzzle664_StrangePrinter {
    public static void main(String[] args) {
        Puzzle664_StrangePrinter p = new Puzzle664_StrangePrinter();
        Solution s = p.new Solution();
        System.out.println(s.strangePrinter("abcabc")); // 5
        System.out.println(s.strangePrinter("aaabbb")); // 2
        System.out.println(s.strangePrinter("aba"));    // 2
        System.out.println(s.strangePrinter("tbgtgb")); // 4
        System.out.println(s.strangePrinter("dddccbdbababaddcbcaabdbdddcccddbbaabddb")); // 15

    }

    class Solution {
        public int strangePrinter(String s) {
            int len = s.length();
            if (len < 2) return len;

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                while (i < len - 1 && s.charAt(i + 1) == s.charAt(i)) i++;
                builder.append(s.charAt(i));
            }
            s = builder.toString();
            len = s.length();

            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) dp[i][i] = 1;

            for (int partLen = 2; partLen <= len; partLen++)
                for (int begin = 0; begin < len - 1; begin++) {
                    int end = begin + partLen - 1;
                    if (end >= len) break;

                    char curr = s.charAt(end);
                    if (curr == s.charAt(end - 1) || curr == s.charAt(begin))
                        dp[begin][end] = dp[begin][end - 1];
                    else {
                        int min = dp[begin][end - 1] + 1;
                        for (int mid = begin; mid < end; mid++) {
                            min = Math.min(dp[begin][mid] + dp[mid + 1][end], min);
                        }
                        dp[begin][end] = min;
                    }
                }
            return dp[0][len - 1];
        }
    }
}
