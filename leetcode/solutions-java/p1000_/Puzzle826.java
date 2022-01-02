package p1000_;

/**
 * https://leetcode.com/problems/most-profit-assigning-work/
 *
 * @author half-dead
 */
public class Puzzle826 {
    class Solution {
        public int maxProfitAssignment(int[] d, int[] p, int[] worker) {
            int[] preMax = new int[100001];
            for (int i = 0; i < p.length; i++) {
                preMax[d[i]] = Math.max(p[i], preMax[d[i]]);
            }
            for (int i = 1; i < 100001; i++) {
                preMax[i] = Math.max(preMax[i], preMax[i - 1]);
            }
            int sum = 0;
            for (int w : worker) {
                sum += preMax[w];
            }
            return sum;
        }
    }

}
