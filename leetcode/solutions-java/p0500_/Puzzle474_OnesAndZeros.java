package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/ones-and-zeroes/
 *
 * @author half-dead
 */
public class Puzzle474_OnesAndZeros {

    public static void main(String[] args) {
        Solution s = new Puzzle474_OnesAndZeros().new Solution();
        s.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
    }

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (String s : strs) {
                int[] zo = get01(s);
                for (int i = m; i >= zo[0]; i--) {
                    for (int j = n; j >= zo[1]; j--) {
                        dp[i][j] = Math.max(1 + dp[i - zo[0]][j - zo[1]], dp[i][j]);
                    }
                }
//                prettyPrint(dp);
            }
            return dp[m][n];
        }

        public int[] get01(String str) {
            int zeros = 0, ones = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            return new int[]{zeros, ones};
        }

        public void prettyPrint(int[][] ints) {
            for (int[] arr : ints) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("---------------------------");
        }
    }
}
