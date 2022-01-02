package p1500_;

/**
 * https://leetcode.com/problems/shortest-common-supersequence/
 *
 * @author half-dead
 */
public class Puzzle1092 {

    class Solution {
        public String shortestCommonSupersequence(String a, String b) {
            int n = a.length(), m = b.length();
            char[] csa = a.toCharArray(), csb = b.toCharArray();

            String[] dp = new String[n + 1], next;
            for (int i = 0; i <= n; i++) dp[i] = "";

            // find longest common subsequence
            String lcs = "";
            for (int j = 0; j < m; j++) {
                next = new String[n + 1];
                next[0] = "";

                for (int i = 0; i < n; i++) {
                    if (csa[i] == csb[j]) next[i + 1] = dp[i] + csa[i];
                    else if (dp[i + 1].length() > next[i].length()) next[i + 1] = dp[i + 1];
                    else next[i + 1] = next[i];

                    if (next[i + 1].length() > lcs.length()) lcs = next[i + 1];
                }
                dp = next;
            }

            // build result
            int i = 0, j = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : lcs.toCharArray()) {
                while (i < n && csa[i] != c) sb.append(csa[i++]);
                while (j < m && csb[j] != c) sb.append(csb[j++]);
                sb.append(c);
                i++;
                j++;
            }
            while (i < n) sb.append(csa[i++]);
            while (j < m) sb.append(csb[j++]);
            return sb.toString();
        }
    }
}
