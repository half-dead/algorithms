package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-total-importance-of-roads/
 *
 * @author half-dead
 */
public class Puzzle2285 {

    class Solution {
        public long maximumImportance(int n, int[][] roads) {
            int[] cnt = new int[n];
            for (int[] r : roads) {
                cnt[r[0]]++;
                cnt[r[1]]++;
            }
            Arrays.sort(cnt);
            long res = 0;
            for (int i = 0; i < cnt.length; i++) {
                res += cnt[i] * (long) (i + 1);
            }
            return res;
        }
    }
}
