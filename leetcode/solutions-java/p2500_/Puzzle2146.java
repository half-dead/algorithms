package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/
 *
 * @author half-dead
 */
public class Puzzle2146 {

    public static void main(String[] args) {
        //[[1,2,0,1],[1,3,0,1],[0,2,5,1]]
        //[2,5]
        //[0,0]
        //3
        Solution s = new Puzzle2146().new Solution();
        List<List<Integer>> xx = s.highestRankedKItems(new int[][]{{1, 2, 0, 1}, {1, 3, 0, 1}, {0, 2, 5, 1}}, new int[]{2, 5}, new int[]{0, 0}, 3);
        System.out.println(xx);
    }

    // bfs + priority queue
    class Solution {
        public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
            // [dis, price, row, col]
            PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> {
                for (int i = 0; i < 4; i++) {
                    int d = b[i] - a[i];
                    if (d != 0) return d;
                }
                return 0;
            });

            int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int m = grid.length, n = grid[0].length, dis = 0;

            boolean[][] visited = new boolean[m][n];
            visited[start[0]][start[1]] = true;

            Deque<int[]> q = new LinkedList<>();
            q.addLast(start);

            while (q.size() > 0) {
                for (int i = 0, cnt = q.size(); i < cnt; i++) {
                    int[] top = q.pollFirst();
                    int r = top[0], c = top[1];

                    if (grid[r][c] >= pricing[0] && grid[r][c] <= pricing[1]) {
                        pq.offer(new int[]{dis, grid[r][c], r, c});
                        if (pq.size() > k) pq.poll();
                    }

                    for (int[] d : directions) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr < 0 || nr == m || nc < 0 || nc == n || grid[nr][nc] == 0 || visited[nr][nc])
                            continue;
                        visited[nr][nc] = true;
                        q.addLast(new int[]{nr, nc});
                    }
                }
                dis++;
                if (pq.size() == k) break;
            }

            List<List<Integer>> res = new ArrayList<>(pq.size());
            for (int i = 0; i < pq.size(); i++) res.add(new ArrayList<>());
            for (int i = pq.size() - 1; i >= 0; i--) {
                int[] curr = pq.poll();
                res.set(i, Arrays.asList(curr[2], curr[3]));
            }
            return res;
        }
    }

}
