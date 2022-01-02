package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plates-between-candles/
 *
 * @author half-dead
 */
public class Puzzle2055 {

    // find out the closest candle to the left/right of every plate,
    // then use prefix sum to get the count of plates in given range
    class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int n = s.length();
            char[] cs = s.toCharArray();

            int[] platesCount = new int[n + 1];
            int[] closestCandleLeft = new int[n], closestCandleRight = new int[n];

            Arrays.fill(closestCandleLeft, -1);
            for (int i = 0, prev = -1; i < n; i++) {
                if (cs[i] == '|') {
                    closestCandleLeft[i] = prev = i;
                    platesCount[i + 1] = platesCount[i];
                } else {
                    closestCandleLeft[i] = prev;
                    platesCount[i + 1] = platesCount[i] + 1;
                }

            }

            Arrays.fill(closestCandleRight, -1);
            for (int i = n - 1, last = -1; i >= 0; i--) {
                if (cs[i] == '|') {
                    closestCandleRight[i] = last = i;
                } else {
                    closestCandleRight[i] = last;
                }

            }

            int qlen = queries.length;
            int[] res = new int[qlen];
            for (int i = 0; i < qlen; i++) {
                int leftBound = closestCandleRight[queries[i][0]], rightBound = closestCandleLeft[queries[i][1]];
                if (leftBound >= 0 && rightBound >= 0 && rightBound > leftBound) {
                    res[i] = platesCount[rightBound + 1] - platesCount[leftBound];
                }
            }
            return res;
        }
    }
}
