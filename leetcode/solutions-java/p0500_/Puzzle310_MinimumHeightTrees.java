package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 *
 * @author half-dead
 */
public class Puzzle310_MinimumHeightTrees {

    public static void main(String[] args) {
        Puzzle310_MinimumHeightTrees p = new Puzzle310_MinimumHeightTrees();
        Solution s = p.new Solution();
        System.out.println(s.findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
        System.out.println(s.findMinHeightTrees(2, new int[][]{{1, 0}}));
        System.out.println(s.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(s.findMinHeightTrees(1, new int[][]{}));
    }

    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] degrees = new int[n];

            for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
            for (int[] edge : edges) {
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
                degrees[edge[0]]++;
                degrees[edge[1]]++;
            }

            LinkedList<Integer> leaves = new LinkedList<>();
            for (int i = 0; i < n; i++)
                if (degrees[i] <= 1) leaves.addLast(i);

            int count = 0;
            List<Integer> result = new ArrayList<>();
            while (leaves.size() > 0) {
                if (leaves.size() + count == n) {
                    result.addAll(leaves);
                    break;
                }

                LinkedList<Integer> newLeaves = new LinkedList<>();
                while (leaves.size() > 0) {
                    count++;
                    int leaf = leaves.removeFirst();
                    for (int adjacent : map.get(leaf)) {
                        if (--degrees[adjacent] == 1) {
                            newLeaves.addLast(adjacent);
                        }
                    }
                }
                leaves = newLeaves;
            }
            return result;
        }
    }

    class DFSSolution {
        private int min = Integer.MAX_VALUE;

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }

            Map<Integer, List<Integer>> hMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int height = dfs(map, -1, i, 0);
                hMap.putIfAbsent(height, new ArrayList<>());
                hMap.get(height).add(i);
                min = Math.min(min, height);
            }
            return hMap.get(min);
        }

        public int dfs(Map<Integer, List<Integer>> graph, int parent, int node, int level) {
            level++;
            if (level > min) {
                return 0;
            }
            if (graph.containsKey(node)) {
                int max = 0;
                for (int next : graph.get(node)) {
                    if (next != parent) {
                        max = Math.max(max, dfs(graph, node, next, level));
                    }
                }
                level += max;
            }
            return level;
        }
    }
}
