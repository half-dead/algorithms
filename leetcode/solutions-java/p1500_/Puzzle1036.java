package p1500_;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.com/problems/escape-a-large-maze/
 *
 * @author half-dead
 */
public class Puzzle1036 {

    public static void main(String[] args) {
        Solution s = new Puzzle1036().new Solution();
        System.out.println(s.isEscapePossible(new int[][]{
                {691938, 300406}, {710196, 624190}, {858790, 609485}, {268029, 225806}, {200010, 188664},
                {132599, 612099}, {329444, 633495}, {196657, 757958}, {628509, 883388}
        }, new int[]{655988, 180910}, new int[]{267728, 840949}));


    }

    class Solution {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int min = 0, max = 1000000;

        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            Set<Long> blocks = new HashSet<>(blocked.length);
            for (int[] block : blocked) {
                long x = block[0], y = block[1];
                blocks.add((x << 32) | y);
            }

            int res = bfs(source, target, blocks);
            if (res != 1) return res == 2;
            return bfs(target, source, blocks) > 0;
        }

        // return 2 if we can reach end from start
        // return 0 if we are blocked
        // otherwise, return 1
        int bfs(int[] start, int[] end, Set<Long> blocks) {
            Deque<int[]> dq = new LinkedList<>();
            dq.addLast(start);
            int maxArea = blocks.size() * (blocks.size() - 1) / 2;
            Set<Long> visited = new HashSet<>(blocks);
            while (dq.size() > 0) {
                for (int size = dq.size(); size > 0; size--) {
                    int[] p = dq.pollFirst();
                    long x = p[0], y = p[1];
                    if (x == end[0] && y == end[1]) return 2;

                    if (blocks.contains((x << 32) | y)) continue;

                    for (int[] d : dirs) {
                        long nx = x + d[0], ny = y + d[1];
                        if (nx < min || nx >= max || ny < min || ny >= max) continue;

                        long hash = (nx << 32) | ny;
                        if (visited.add(hash)) {
                            dq.addLast(new int[]{(int) nx, (int) ny});
                            if (maxArea-- == 0) {
                                return 1;
                            }
                        }
                    }
                }
            }
            return 0;
        }
    }
}
