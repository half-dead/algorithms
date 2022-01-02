package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/distant-barcodes/
 *
 * @author half-dead
 */
public class Puzzle1054 {

    // we only need to find out which barcode has the most occurrences, place it to index 0,2,4,6,8...
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            int[] cnt = new int[10001];
            int idx = -1, max = 0, n = barcodes.length;
            for (int bc : barcodes) {
                if (++cnt[bc] > max) max = cnt[idx = bc];
            }

            for (int i = 0; i < n; i += 2) {
                while (cnt[idx] == 0) {
                    idx = (idx + 1) % 10001;
                }
                barcodes[i] = idx;
                --cnt[idx];
            }
            for (int i = 1; i < n; i += 2) {
                while (cnt[idx] == 0) {
                    idx = (idx + 1) % 10001;
                }
                barcodes[i] = idx;
                --cnt[idx];
            }
            return barcodes;
        }
    }

    // bucket sort
    class Solution1 {
        public int[] rearrangeBarcodes(int[] barcodes) {
            int[][] cnt = new int[10001][2];
            for (int i = 0; i < 10001; i++) cnt[i][1] = i;
            for (int bc : barcodes) cnt[bc][0]++;
            Arrays.sort(cnt, (a, b) -> b[0] - a[0]);
            int n = barcodes.length, j = 0;
            for (int i = 0; i < n; i += 2) {
                barcodes[i] = cnt[j][1];
                if (--cnt[j][0] == 0) j++;
            }
            for (int i = 1; i < n; i += 2) {
                barcodes[i] = cnt[j][1];
                if (--cnt[j][0] == 0) j++;
            }
            return barcodes;
        }
    }
}
