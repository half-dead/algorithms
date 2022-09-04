package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/
 *
 * @author half-dead
 */
public class Puzzle2271 {


    class Solution {
        public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
            int n = tiles.length, res = 0;

            int[] start = new int[n], end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = tiles[i][0];
                end[i] = tiles[i][1];
            }

            Arrays.sort(start);
            Arrays.sort(end);

            int[] ps = new int[n];
            for (int i = 0; i < n; i++) {
                ps[i] = (i == 0 ? 0 : ps[i - 1]) + end[i] - start[i] + 1;
            }

            for (int i = 0; i < n; i++) {
                int left = start[i], right = left + carpetLen - 1;
                int pos = Arrays.binarySearch(end, right);
                if (pos < 0) {
                    pos = -pos - 1 - 1;
                }
                int cover = ps[pos] - (i == 0 ? 0 : ps[i - 1]);
                if (pos + 1 < n) {
                    cover += Math.max(0, right - start[pos + 1] + 1);
                }
                res = Math.max(res, cover);
            }

            for (int i = n - 1; i >= 0; i--) {
                int right = end[i], left = right - carpetLen + 1;
                int pos = Arrays.binarySearch(start, left);
                if (pos < 0) {
                    pos = -pos - 1;
                }
                int cover = ps[i] - (pos == 0 ? 0 : ps[pos - 1]);
                if (pos > 0) {
                    cover += Math.max(0, end[pos - 1] - left + 1);
                }
                res = Math.max(res, cover);
            }

            return res;
        }
    }
}
