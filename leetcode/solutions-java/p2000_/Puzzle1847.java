package p2000_;

import java.util.*;

/**
 * @author half-dead
 */
public class Puzzle1847 {

    // sorting, treeset
    class Solution {
        public int[] closestRoom(int[][] rooms, int[][] queries) {
            int n = queries.length, m = rooms.length;

            int[][] q = new int[n][3];
            for (int i = 0; i < n; i++) q[i] = new int[]{i, queries[i][0], queries[i][1]};
            Arrays.sort(q, (a, b) -> b[2] - a[2]);

            Arrays.sort(rooms, (a, b) -> b[1] - a[1]);

            int[] res = new int[n];
            TreeSet<Integer> ts = new TreeSet<>();
            for (int i = 0, j = 0; i < n; i++) {
                int index = q[i][0], prefer = q[i][1], size = q[i][2];
                while (j < m && rooms[j][1] >= size) ts.add(rooms[j++][0]);

                Integer floor = ts.floor(prefer), ceiling = ts.ceiling(prefer);
                if (floor == null && ceiling == null) {
                    res[index] = -1;
                } else if (floor == null) {
                    res[index] = ceiling;
                } else if (ceiling == null) {
                    res[index] = floor;
                } else if (prefer - floor <= ceiling - prefer) {
                    res[index] = floor;
                } else {
                    res[index] = ceiling;
                }
            }
            return res;
        }
    }
}
