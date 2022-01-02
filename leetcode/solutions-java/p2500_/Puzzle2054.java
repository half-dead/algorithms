package p2500_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/two-best-non-overlapping-events/
 *
 * @author half-dead
 */
public class Puzzle2054 {

    public static void main(String[] args) {
        Solution s = new Puzzle2054().new Solution();
        System.out.println(s.maxTwoEvents(new int[][]{
                {1, 5, 3}, {1, 5, 1}, {6, 6, 5}
        }));
    }

    // two pass, sort + treemap
    class Solution1 {
        public int maxTwoEvents(int[][] events) {
            Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

            TreeMap<Integer, Integer> tm = new TreeMap<>();
            tm.put(0, 0);
            for (int[] e : events) {
                int max = tm.lastEntry().getValue();
                tm.put(e[1], Math.max(e[2], max));
            }

            Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
            int res = 0;
            for (int[] e : events) {
                res = Math.max(res, e[2] + tm.floorEntry(e[0] - 1).getValue());
            }
            return res;
        }
    }

    // sort + pq
    class Solution {
        public int maxTwoEvents(int[][] events) {
            int res = 0, max = 0;

            Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

            for (int[] e : events) {
                while (!pq.isEmpty() && pq.peek()[1] < e[0]) {
                    max = Math.max(max, pq.poll()[2]);
                }
                res = Math.max(res, max + e[2]);
                pq.add(e);
            }
            return res;
        }
    }
}
