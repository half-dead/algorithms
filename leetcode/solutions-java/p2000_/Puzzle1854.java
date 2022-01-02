package p2000_;

/**
 * https://leetcode.com/problems/maximum-population-year/
 *
 * @author half-dead
 */
public class Puzzle1854 {

    class Solution {
        public int maximumPopulation(int[][] logs) {
            int[] p = new int[101];
            for (int[] log : logs) {
                p[log[0] - 1950]++;
                p[log[1] - 1950]--;
            }

            int max = p[0], res = 0;
            for (int i = 1; i <= 100; i++) {
                p[i] += p[i - 1];
                if (p[i] > max) {
                    max = p[i];
                    res = i;
                }
            }
            return res + 1950;
        }
    }
}
