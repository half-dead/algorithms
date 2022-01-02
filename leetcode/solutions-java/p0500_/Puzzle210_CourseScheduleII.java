package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * @author half-dead
 */
public class Puzzle210_CourseScheduleII {
    class Solution {
        public int[] findOrder(int num, int[][] pres) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] pre : pres) {
                graph.putIfAbsent(pre[1], new ArrayList<>());
                graph.get(pre[1]).add(pre[0]);
            }

            LinkedList<Integer> queue = new LinkedList<>();
            boolean[][] marker = new boolean[num][2];
            for (int i = 0; i < num; i++) {
                if (!dfs(graph, marker, i, queue)) {
                    return new int[]{};
                }
            }

            int[] res = new int[queue.size()];
            int i = 0;
            while (queue.size() > 0) {
                res[i++] = queue.pop();
            }
            return res;
        }

        private boolean dfs(Map<Integer, List<Integer>> graph, boolean[][] marker, int from, LinkedList<Integer> list) {
            if (marker[from][1]) return true;
            if (marker[from][0]) return false;

            marker[from][0] = true;
            if (graph.containsKey(from)) {
                for (int next : graph.get(from)) {
                    if (!dfs(graph, marker, next, list)) return false;
                }
            }
            list.push(from);
            marker[from][1] = true;
            return true;
        }
    }

    class BFSSolution {
        public int[] findOrder(int num, int[][] pres) {
            int[] courses = new int[num];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] pre : pres) {
                courses[pre[0]]++;
                map.putIfAbsent(pre[1], new ArrayList<>());
                map.get(pre[1]).add(pre[0]);
            }

            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                if (courses[i] == 0) q.push(i);
            }

            int[] result = new int[num];
            int i = 0, count = 0;
            while (q.size() > 0) {
                int pre = q.pop();
                count++;
                result[i++] = pre;
                if (map.containsKey(pre)) {
                    for (int next : map.get(pre)) {
                        if (--courses[next] == 0) {
                            q.push(next);
                        }
                    }
                }
            }
            return count == num ? result : new int[]{};
        }
    }
}
