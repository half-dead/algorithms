package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/process-restricted-friend-requests/
 *
 * @author half-dead
 */
public class Puzzle2076 {

    // standard union find
    class Solution {
        class UF {
            int[] p;

            UF(int n) {
                p = new int[n];
                for (int i = 0; i < n; i++) p[i] = i;
            }

            int find(int x) {
                if (p[x] == x) return x;
                return p[x] = find(p[x]);
            }

            void union(int x, int y) {
                p[find(x)] = find(y);
            }

            boolean connected(int x, int y) {
                return find(x) == find(y);
            }
        }

        public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
            UF uf = new UF(n);

            int m = requests.length;
            boolean[] res = new boolean[m];
            for (int i = 0; i < m; i++) {
                int pu = uf.find(requests[i][0]), pv = uf.find(requests[i][1]);

                boolean b = true;
                if (!uf.connected(pu, pv)) {
                    for (int[] ban : restrictions) {
                        int x = uf.find(ban[0]), y = uf.find(ban[1]);
                        if ((x == pu && y == pv) || (x == pv && y == pu)) {
                            b = false;
                            break;
                        }
                    }
                }

                res[i] = b;
                if (b) uf.union(pu, pv);
            }
            return res;
        }
    }

}
