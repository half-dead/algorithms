package p1500_;

import java.util.*;

/**
 * https://leetcode.com/problems/grid-illumination/
 *
 * @author half-dead
 */
public class Puzzle1001 {

    public static void main(String[] args) {
        Solution s = new Puzzle1001().new Solution();
        System.out.println(Arrays.toString(s.gridIllumination(5, new int[][]{
                {0, 0}, {4, 4}
        }, new int[][]{
                {1, 1}, {1, 0}
        })));
    }

    class Solution {
        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
            Map<Integer, Integer> rmap = new HashMap<>(), cmap = new HashMap<>();
            Map<Integer, Integer> dmap = new HashMap<>(), rdmap = new HashMap<>();

            Set<Long> set = new HashSet<>(lamps.length);
            for (int[] lamp : lamps) {
                int r = lamp[0], c = lamp[1];
                if (set.add(((long) r << 32) | (long) c)) {
                    rmap.put(r, rmap.getOrDefault(r, 0) + 1);
                    cmap.put(c, cmap.getOrDefault(c, 0) + 1);
                    dmap.put(r - c, dmap.getOrDefault(r - c, 0) + 1);
                    rdmap.put(r + c, rdmap.getOrDefault(r + c, 0) + 1);
                }
            }

            int m = queries.length;
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                int[] q = queries[i];
                int r = q[0], c = q[1];
                if (rmap.getOrDefault(r, 0) > 0 || cmap.getOrDefault(c, 0) > 0
                        || dmap.getOrDefault(r - c, 0) > 0 || rdmap.getOrDefault(r + c, 0) > 0) {
                    ans[i] = 1;
                }
                for (int x = -1; x <= 1; x++)
                    for (int y = -1; y <= 1; y++) {
                        int nr = r + x, nc = c + y;
                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                        if (set.remove(((long) nr << 32) | (long) nc)) {
                            rmap.put(nr, rmap.getOrDefault(nr, 0) - 1);
                            cmap.put(nc, cmap.getOrDefault(nc, 0) - 1);
                            dmap.put(nr - nc, dmap.getOrDefault(nr - nc, 0) - 1);
                            rdmap.put(nr + nc, rdmap.getOrDefault(nr + nc, 0) - 1);
                        }
                    }
            }
            return ans;
        }
    }
}
