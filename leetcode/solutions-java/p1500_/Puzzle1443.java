package p1500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 *
 * @author half-dead
 */
public class Puzzle1443 {

    public static void main(String[] args) {
        Solution s = new Puzzle1443().new Solution();
        System.out.println(s.minTime(
                7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                Arrays.asList(false, false, true, false, true, true, false)
        ));
    }

    class Solution {
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            List<Integer>[] map = new ArrayList[n];
            for (int i = 0; i < n; i++) map[i] = new ArrayList<>();
            for (int[] edge : edges) {
                map[edge[0]].add(edge[1]);
                map[edge[1]].add(edge[0]);
            }

            boolean[] visited = new boolean[n];
            int res = dfs(map, hasApple, visited, 0);
            return res == 0 ? 0 : res - 2;
        }

        int dfs(List<Integer>[] map, List<Boolean> hasApple, boolean[] visited, int vertex) {
            visited[vertex] = true;

            int res = 0;
            for (int i : map[vertex]) if (!visited[i]) res += dfs(map, hasApple, visited, i);

            if (res > 0 || hasApple.get(vertex)) res += 2;
            return res;
        }
    }
}
