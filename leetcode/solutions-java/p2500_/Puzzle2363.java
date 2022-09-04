package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-similar-items/
 *
 * @author half-dead
 */
public class Puzzle2363 {

    class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] a, int[][] b) {
            Arrays.sort(a, (x, y) -> {
                return x[0] - y[0];
            });
            Arrays.sort(b, (x, y) -> {
                return x[0] - y[0];
            });

            int i = 0, j = 0, m = a.length, n = b.length;
            List<List<Integer>> res = new ArrayList<>();
            while (i < m || j < n) {
                List<Integer> temp = new ArrayList<>(2);
                if (i == m || (j < n && b[j][0] < a[i][0])) {
                    temp.add(b[j][0]);
                    temp.add(b[j][1]);
                    j++;
                } else if (j == n || a[i][0] < b[j][0]) {
                    temp.add(a[i][0]);
                    temp.add(a[i][1]);
                    i++;
                } else {
                    temp.add(a[i][0]);
                    temp.add(a[i][1] + b[j][1]);
                    i++;
                    j++;
                }
                res.add(temp);
            }
            return res;
        }
    }
}
