package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1578 {

    class Solution {
        public int minCost(String s, int[] cost) {
            char[] cs = s.toCharArray();

            int len = cs.length, cnt = 0, res = 0;
            char prev = ' ';
            for (int i = 0; i <= len; i++) {
                char c = i < len ? cs[i] : ' ';
                if (c == prev) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        int sum = 0, max = 0;
                        for (int j = i - 1, t = 1; t <= cnt; j--, t++) {
                            sum += cost[j];
                            max = Math.max(max, cost[j]);
                        }
                        res += sum - max;
                    }
                    cnt = 1;
                    prev = c;
                }
            }
            return res;
        }
    }
}
