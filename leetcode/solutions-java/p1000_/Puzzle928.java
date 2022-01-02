package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-malware-spread-ii/
 *
 * @author half-dead
 */
public class Puzzle928 {

    public static void main(String[] args) {
        Solution s = new Puzzle928().new Solution();
        System.out.println(s.minMalwareSpread(new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 0, 0, 1}
        }, new int[]{8, 4, 2, 0}));


    }

    class Solution {
        public int minMalwareSpread(int[][] graph, int[] initial) {
            Arrays.sort(initial);

            int n = graph.length, res = initial[0], maxSaved = 0;
            int[] saved = new int[n];

            boolean[] malwares = new boolean[n], visited = new boolean[n];
            for (int node : initial) malwares[node] = true;

            for (int node = 0; node < n; node++) {
                if (malwares[node] || visited[node]) continue;

                // mark all initial infected nodes as unvisited
                for (int infected : initial) visited[infected] = false;

                // holder[0] = count of reachable infected nodes
                // holder[1] = count of reachable healthy nodes
                // holder[2] = the initial infected node,
                int[] holder = new int[3];
                dfs(node, visited, malwares, graph, n, holder);
                if (holder[0] == 1) saved[holder[2]] += holder[1];
            }

            // find the node that can save most healthy nodes
            for (int i = 0; i < n; i++) {
                if (saved[i] > maxSaved) {
                    maxSaved = saved[i];
                    res = i;
                }
            }
            return res;
        }

        // we only go through healthy nodes
        void dfs(int node, boolean[] visited, boolean[] malwares, int[][] g, int n, int[] holder) {
            if (visited[node]) return;
            visited[node] = true;

            // reached an infected node, increment holder[0] and set holder[2]
            if (malwares[node]) {
                holder[0]++;
                holder[2] = node;
                return;
            }

            // reached a healthy node, increment holder[1]
            holder[1]++;

            for (int next = 0; next < n; next++) {
                if (g[node][next] == 0 || visited[next]) continue;

                dfs(next, visited, malwares, g, n, holder);
            }
        }
    }
}
