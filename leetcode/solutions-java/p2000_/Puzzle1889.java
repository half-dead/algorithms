package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-space-wasted-from-packaging/
 *
 * @author half-dead
 */
public class Puzzle1889 {


    // prefix-sum, cnt by frequency, sorting
    class Solution {
        public int minWastedSpace(int[] packages, int[][] suppliers) {
            int max = 0, mod = (int) 1e9 + 7;
            long res = Long.MAX_VALUE, sum = 0L;

            int[] freq = new int[100001];
            for (int p : packages) {
                freq[p]++;
                sum += p;
                max = Math.max(max, p);
            }

            for (int i = 1; i < 100001; i++) {
                freq[i] += freq[i - 1];
            }

            boolean b = false;
            for (int[] boxes : suppliers) {
                Arrays.sort(boxes);

                int m = boxes.length, i = 0, prev = 0;
                if (boxes[m - 1] < max) continue;

                long provided = 0L;
                while (i < m) {
                    int cap = boxes[i];
                    provided += (long) cap * (freq[cap] - freq[prev]);
                    prev = cap;

                    if (cap > max) break;
                    i++;
                }
                b = true;
                res = Math.min(res, provided - sum);
            }

            return !b ? -1 : (int) (res % mod);
        }
    }
}
