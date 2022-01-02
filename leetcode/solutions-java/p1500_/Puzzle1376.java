package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 *
 * @author half-dead
 */
public class Puzzle1376 {

    // Bottom-up DFS
    class Solution {

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dfs(i, manager, informTime));
            }
            return res;
        }

        private int dfs(int e, int[] m, int[] it) {
            if (m[e] != -1) {
                it[e] += dfs(m[e], m, it);
                m[e] = -1;
            }
            return it[e];
        }
    }

    // Top-down DFS
    class Solution1 {
        List<Integer>[] map;
        int[] res = new int[1];

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            map = new List[n];
            for (int i = 0; i < n; i++) {
                if (i == headID) continue;
                if (map[manager[i]] == null) map[manager[i]] = new ArrayList<>();
                map[manager[i]].add(i);
            }

            dfs(headID, 0, informTime);
            return res[0];
        }

        void dfs(int e, int t, int[] it) {
            List<Integer> sub = map[e];
            if (sub == null) {
                res[0] = Math.max(res[0], t);
                return;
            }

            t += it[e];
            for (int s : sub) dfs(s, t, it);
        }
    }

}
