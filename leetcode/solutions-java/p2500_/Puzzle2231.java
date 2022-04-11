package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
 */
public class Puzzle2231 {

    public static void main(String[] args) {
        Solution s = new Puzzle2231().new Solution();
        System.out.println(s.largestInteger(1234));
        System.out.println(s.largestInteger(65875));
    }

    class Solution {
        public int largestInteger(int num) {
            String s = num + "";

            int n = s.length();
            char[] cs = s.toCharArray(), ans = new char[n];
            boolean[] b = new boolean[n];

            for (int i = 0; i < n; i++) {
                b[i] = (cs[i] - '0') % 2 == 0;
            }

            Arrays.sort(cs);
            for (int i = n - 1; i >= 0; i--) {
                boolean even = (cs[i] - '0') % 2 == 0;
                for (int j = 0; j < n; j++) {
                    if ((even == b[j]) && ans[j] == 0) {
                        ans[j] = cs[i];
                        break;
                    }
                }
            }
            return Integer.parseInt(new String(ans));
        }
    }
}
