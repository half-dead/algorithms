package p2000_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
 *
 * @author half-dead
 */
public class Puzzle1722 {

    public static void main(String[] args) {
        Solution s = new Puzzle1722().new Solution();
        System.out.println(s.minimumHammingDistance(new int[]{
                1, 2, 3, 4
        }, new int[]{
                2, 1, 4, 5
        }, new int[][]{
                {0, 1}, {2, 3}
        }));
    }

    class Solution {
        public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
            int len = source.length, res = 0;

            int[] dsf = new int[len];
            for (int i = 0; i < len; i++) dsf[i] = i;

            boolean[] b = new boolean[len];
            for (int[] as : allowedSwaps) {
                union(as[0], as[1], dsf);
                b[as[0]] = b[as[1]] = true;
            }

            Map<Integer, Set<Integer>> dsmap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int root = find(i, dsf);
                dsmap.computeIfAbsent(root, (a) -> new HashSet<>()).add(i);
            }

            for (Set<Integer> set : dsmap.values()) {
                if (set.size() == 1) continue;

                Map<Integer, Integer> temp = new HashMap<>();
                for (int j : set) {
                    temp.put(source[j], temp.getOrDefault(source[j], 0) + 1);
                    temp.put(target[j], temp.getOrDefault(target[j], 0) - 1);
                }
                for (int v : temp.values()) if (v > 0) res += v;
            }

            for (int i = 0; i < len; i++) if (!b[i] && source[i] != target[i]) res++;
            return res;
        }

        void union(int x, int y, int[] ds) {
            int rx = find(x, ds), ry = find(y, ds);
            if (rx != ry) ds[rx] = ry;
        }

        int find(int x, int[] ds) {
            while (x != ds[x]) {
                ds[x] = find(ds[x], ds);
                x = ds[x];
            }
            return x;
        }
    }
}
