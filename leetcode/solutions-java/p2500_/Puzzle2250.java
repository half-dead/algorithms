package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/count-number-of-rectangles-containing-each-point/
 *
 * @author half-dead
 */
public class Puzzle2250 {

    class Solution {
        public int[] countRectangles(int[][] rectangles, int[][] points) {
            int n = points.length;
            int[] res = new int[n];
            Map<Integer, List<Integer>> map = new HashMap<>(100);
            for (int[] rect : rectangles) {
                int x = rect[0], y = rect[1];
                map.computeIfAbsent(y, o -> new ArrayList<>()).add(x);
            }
            for (List<Integer> list : map.values()) {
                Collections.sort(list);
            }
            for (int i = 0; i < n; i++) {
                int x = points[i][0], y = points[i][1], cnt = 0;
                for (int j = y; j <= 100; j++) {
                    List<Integer> list = map.get(j);
                    if (list == null) continue;

                    int ip = Collections.binarySearch(list, x);
                    if (ip < 0) {
                        ip = -ip - 1;
                    }
                    cnt += list.size() - ip;
                }
                res[i] = cnt;
            }
            return res;
        }
    }
}
