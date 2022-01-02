package p1000_;

import util.Print;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/find-the-shortest-superstring/
 *
 * @author half-dead
 */
public class Puzzle943 {
    public static void main(String[] args) {
        Solution s = new Puzzle943().new Solution();
        System.out.println(s.shortestSuperstring(new String[]{"catg", "ctaagt", "gcta", "ttca", "atgcatc"}));
        System.out.println(s.shortestSuperstring(new String[]{"wmiy", "yarn", "rnnwc", "arnnw", "wcj"}));
    }

    // classic Travelling Salesman Problem
    class Solution {
        public String shortestSuperstring(String[] a) {
            int len = a.length, n = 1 << len;
            int[][] graph = new int[len][len];
            for (int i = 0; i < len; i++)
                for (int j = 0; j < len; j++)
                    if (i != j) graph[i][j] = cal(a[i], a[j]);

            int min = Integer.MAX_VALUE, last = -1;
            int[][] dp = new int[n][len], path = new int[n][len];
            for (int i = 1; i < n; i++) {
                Arrays.fill(dp[i], -1);

                for (int j = 0; j < len; j++) {
                    int shift = 1 << j;
                    if ((i & shift) == 0) continue;

                    int prev = i ^ shift;
                    if (prev == 0) dp[i][j] = a[j].length();
                    else {
                        for (int k = 0; k < len; k++) {
                            if (dp[prev][k] == -1) continue;

                            int temp = dp[prev][k] + a[j].length() - graph[k][j];
                            if (dp[i][j] < 0 || temp < dp[i][j]) {
                                dp[i][j] = temp;
                                path[i][j] = k;
                            }
                        }
                    }

                    if (i == n - 1 && dp[i][j] < min) {
                        min = dp[i][j];
                        last = j;
                    }
                }
            }

            Print.pt(dp);
            Print.pt(path);
            
            LinkedList<Integer> stack = new LinkedList<>();
            int target = n - 1;
            while (target > 0) {
                int prev = path[target][last];
                target = target ^ (1 << last);
                stack.push(last);
                last = prev;
            }

            int i = stack.pop();
            StringBuilder result = new StringBuilder(a[i]);
            while (stack.size() > 0) {
                int j = stack.pop();
                result.append(a[j], graph[i][j], a[j].length());
                i = j;
            }
            return result.toString();
        }

        private int cal(String a, String b) {
            char[] ca = a.toCharArray(), cb = b.toCharArray();
            int max = Math.min(ca.length, cb.length) - 1, i = ca.length - max;
            while (i < ca.length) {
                int ia = i, ib = 0;
                while (ia < ca.length && ca[ia] == cb[ib]) {
                    ia++;
                    ib++;
                }
                if (ia == ca.length) return ca.length - i;
                i++;
            }
            return 0;
        }
    }
}
