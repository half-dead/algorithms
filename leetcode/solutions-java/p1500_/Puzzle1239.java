package p1500_;

import java.util.Arrays;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle1239 {

    public static void main(String[] args) {
        Solution s = new Puzzle1239().new Solution();
        System.out.println(s.maxLength(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p")));
//        System.out.println(s.maxLength(Arrays.asList("un", "iq", "ue")));
//        System.out.println(s.maxLength(Arrays.asList("cha", "r", "act", "ers")));
//        System.out.println(s.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
//        System.out.println(s.maxLength(Arrays.asList("yy", "bkhwmpbiisbldzknpm")));
    }

    // Dfs, O(2^N) time, O(N) space
    class Solution {
        public int maxLength(List<String> list) {
            int len = list.size();
            int[] ans = new int[1];
            int[][] bitMap = new int[len][2];
            for (int i = 0; i < len; i++) {
                String s = list.get(i);
                int code = 0;
                for (char ch : s.toCharArray()) {
                    int shift = 1 << (ch - 'a');
                    if ((code | shift) == code) {
                        code = 0;
                        break;
                    }
                    code |= shift;
                }
                bitMap[i][0] = code;
                bitMap[i][1] = code == 0 ? 0 : s.length();
            }
            dfs(bitMap, ans, 0, 0, 0);
            return ans[0];
        }

        private void dfs(int[][] bitMap, int[] ans, int start, int curLen, int curBit) {
            if (ans[0] < curLen) ans[0] = curLen;
            for (int i = start; i < bitMap.length; i++) {
                if ((curBit & bitMap[i][0]) != 0) continue;
                dfs(bitMap, ans, i + 1, curLen + bitMap[i][1], curBit | bitMap[i][0]);
            }
        }
    }

    // Dp O(n * 2^N) time, O(2^N) space
    class DpSolution {
        public int maxLength(List<String> list) {
            int n = list.size(), i = 0, max = 0, total = 1 << n;
            int[] arr = new int[n], comp = new int[n], state = new int[total];
            for (String s : list) {
                int code = 0;
                for (char c : s.toCharArray()) {
                    int shift = 1 << (c - 'a');
                    if ((code & shift) != 0) {
                        code = 0;
                        break;
                    } else {
                        code |= shift;
                    }
                }
                arr[i++] = code;
            }

            for (i = 0; i < n; i++) comp[i] = 1 << i;
            boolean[] dp = new boolean[total];
            dp[0] = true;
            for (i = 0; i < total; i++) {
                if (!dp[i]) continue;

                for (int j = 0; j < n; j++) {
                    if (arr[j] == 0) continue;

                    int next = i | comp[j];
                    if (i != next && (state[i] & arr[j]) == 0) {
                        state[i] = state[i] | arr[j];
                        max = Math.max(max, Integer.bitCount(state[i]));
                        dp[next] = true;
                    }
                }
            }
            return max;
        }
    }
}
