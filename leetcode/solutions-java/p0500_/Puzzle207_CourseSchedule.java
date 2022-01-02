package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * @author half-dead
 */
public class Puzzle207_CourseSchedule {

    public static void main(String[] args) {
        Puzzle207_CourseSchedule p = new Puzzle207_CourseSchedule();
        Solution s = p.new Solution();
        System.out.println(s.canFinish(3, new int[][]{{2, 1}, {1, 0}}));
    }


    class Solution {
        public boolean canFinish(int num, int[][] pres) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < num; i++) {
                set.add(i);
            }
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] pre : pres) {
                set.remove(pre[0]);
                map.putIfAbsent(pre[0], new HashSet<>());
                map.get(pre[0]).add(pre[1]);
            }

            while (map.size() > 0) {
                int before = map.size();
                List<Integer> list = new ArrayList<>(map.keySet());
                for (int post : list) {
                    if (set.containsAll(map.get(post))) {
                        set.add(post);
                        map.remove(post);
                    }
                }
                if (map.size() > 0 && before == map.size()) {
                    return false;
                }
            }
            return true;
        }
    }

    class BFSSolution {
        public boolean canFinish(int num, int[][] pres) {
            int[] courses = new int[num];
            boolean[][] matrix = new boolean[num][num];
            for (int[] pre : pres) {
                matrix[pre[1]][pre[0]] = true;
                courses[pre[0]]++;
            }

            // push courses that have no prerequisites into queue
            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 0; i < courses.length; i++)
                if (courses[i] == 0) q.push(i);

            int count = 0;
            while (!q.isEmpty()) {
                count++;
                int pre = q.poll();
                // for every course, decrease it's neighbour's prerequisites count by 1
                // if the neighbour's prerequisites count reaches zero, push this neighbour into queue
                for (int i = 0; i < num; i++)
                    if (matrix[pre][i] && --courses[i] == 0) q.push(i);

            }
            return count == num;
        }
    }

    class DFSSolution {
        public boolean canFinish(int num, int[][] pres) {
            ArrayList<Integer>[] graph = new ArrayList[num];
            for (int i = 0; i < num; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] pre : pres) {
                graph[pre[1]].add(pre[0]);
            }

            boolean[] visited = new boolean[num], finished = new boolean[num];
            for (int i = 0; i < num; i++) {
                if (!dfs(graph, visited, finished, i)) {
                    return false;
                }
            }
            return true;
        }

        boolean dfs(ArrayList[] graph, boolean[] visited, boolean[] finished, int from) {
            if (finished[from]) {
                return true;
            } else if (visited[from]) {
                return false;
            } else {
                visited[from] = true;
            }

            for (int i = 0; i < graph[from].size(); i++) {
                int next = (int) graph[from].get(i);
                if (!dfs(graph, visited, finished, next)) {
                    return false;
                }
            }

            finished[from] = true;
            return true;
        }
    }

    class TrickySolution {
        public boolean canFinish(int num, int[][] pres) {
            int[] root1 = new int[num], root2 = new int[num];
            for (int i = 0; i < num; ++i)
                root1[i] = root2[i] = i;

            int[][] reverse = new int[pres.length][2];
            for (int i = 0; i < pres.length; ++i) {
                reverse[i][0] = pres[i][1];
                reverse[i][1] = pres[i][0];
            }
            return noCycle(pres, root1) && noCycle(reverse, root2);
        }

        private boolean noCycle(int[][] edges, int[] root) {
            for (int[] edge : edges) {
                int left = edge[1], right = edge[0];
                while (root[left] != left) {
                    left = root[left];
                    if (left == right) {
                        return false;
                    }
                }
                root[right] = left;
            }
            return true;
        }
    }
}
