package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 *
 * @author half-dead
 */
public class Puzzle1584 {

    public static void main(String[] args) {
        Solution s = new Puzzle1584().new Solution();
        System.out.println(s.minCostConnectPoints(new int[][]{{2, -3}, {-17, -8}, {13, 8}, {-17, -15}}));
    }

    // prim's algorithm, using PriorityQueue
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int len = points.length, res = 0, v = 1;

            int[] mst = new int[len];
            Set<Integer> set = new HashSet<>();
            set.add(0);
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            while (v < len) {
                for (int i : set) {
                    if (mst[i] == len - 1) {
                        continue;
                    }
                    for (int j = 0; j < len; j++) {
                        if (j != i && !set.contains(j)) {
                            pq.offer(new int[]{Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), i, j});
                            mst[i]++;
                            mst[j]++;
                        }
                    }
                }
                int[] e = pq.peek();
                while (set.contains(e[1]) && set.contains(e[2])) {
                    pq.poll();
                    e = pq.peek();
                }
                e = pq.poll();
                res += e[0];
                set.add(e[1]);
                set.add(e[2]);
                v++;
            }
            return res;
        }
    }

    // optimized prim
    class Solution2 {
        public int minCostConnectPoints(int[][] points) {
            return prims(points);
        }

        public int prims(int[][] points) {
            int currIndex = 0;
            int res = 0;
            int v = 0;
            int len = points.length;

            int[] minDistances = new int[len];
            Arrays.fill(minDistances, 10000000);

            while (++v < len) {
                int minJ = currIndex;
                minDistances[currIndex] = Integer.MAX_VALUE;

                for (int j = 0; j < len; ++j) {
                    if (minDistances[j] != Integer.MAX_VALUE) {
                        minDistances[j] = Math.min(minDistances[j], Math.abs(points[currIndex][0] - points[j][0]) + Math.abs(points[currIndex][1] - points[j][1]));
                        minJ = minDistances[j] < minDistances[minJ] ? j : minJ;
                    }
                }

                res += minDistances[minJ];
                currIndex = minJ;
            }

            return res;
        }
    }
}
