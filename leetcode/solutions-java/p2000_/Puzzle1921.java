package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
 *
 * @author half-dead
 */
public class Puzzle1921 {

    class Solution {
        public int eliminateMaximum(int[] dist, int[] speed) {
            int len = dist.length, cnt = 1;

            for (int i = 0; i < len; i++) dist[i] = (dist[i] - 1) / speed[i];
            Arrays.sort(dist);

            for (int i = 1; i < len; i++) {
                if (dist[i] < cnt) break;
                cnt++;
            }
            return cnt;
        }
    }
}
