package p1500_;

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * @author half-dead
 */
public class Puzzle1319 {

    // union find
    class Solution {
        int[] dsf;

        public int makeConnected(int n, int[][] conns) {
            if (conns.length < n - 1) return -1;

            dsf = new int[n];
            for (int i = 0; i < n; i++) dsf[i] = i;

            for (int[] conn : conns) {
                union(conn[0], conn[1]);
            }

            int[] g = new int[n];
            int gc = 0;
            for (int i = 0; i < n; i++) {
                int ri = find(i);
                if (g[ri]++ == 0) gc++;
            }
            return gc - 1;
        }

        void union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx == ry) {
                return;
            }
            dsf[rx] = ry;
        }

        int find(int x) {
            while (x != dsf[x]) {
                dsf[x] = find(dsf[x]);
                x = dsf[x];
            }
            return x;
        }
    }
}
