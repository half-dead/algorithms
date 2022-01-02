package p1000_;

import util.Print;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/prison-cells-after-n-days/
 *
 * @author half-dead
 */
public class Puzzle957 {
    public static void main(String[] args) {
        Solution s = new Puzzle957().new Solution();
        Print.pt(s.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7));
        Print.pt(s.prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000));
        Print.pt(s.prisonAfterNDays(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 99));
    }

    class Solution {
        public int[] prisonAfterNDays(int[] cells, int n) {
            Map<Integer, Integer> map = new HashMap<>(128), dmap = new HashMap<>(128);
            int d = 0, period = 0, key = toInt(cells);
            int[] next = new int[8];
            while (++d <= n) {
                if (map.containsKey(key)) {
                    key = map.get(key);
                    if (period == 0) {
                        period = d - dmap.get(key);
                        d += period * ((n - d) / period);
                    }
                } else {
                    for (int i = 1; i <= 6; i++) next[i] = (cells[i - 1] ^ cells[i + 1]) ^ 1;

                    int nextKey = toInt(next);
                    if (key == nextKey)
                        break;

                    map.put(key, nextKey);
                    dmap.put(nextKey, d);
                    key = nextKey;

                    cells[0] = cells[7] = 0;
                    int[] temp = cells;
                    cells = next;
                    next = temp;
                }
            }

            for (int i = 1; i <= 6; i++) next[i] = 1 & (key >> (7 - i));
            return next;
        }

        int toInt(int[] cells) {
            int n = 0;
            for (int v : cells) n = (n << 1) | v;
            return n;
        }
    }
}
