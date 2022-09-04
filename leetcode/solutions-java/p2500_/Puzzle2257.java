package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
 *
 * @author half-dead
 */
public class Puzzle2257 {

    public static void main(String[] args) {
        Solution s = new Puzzle2257().new Solution();
        System.out.println(s.countUnguarded(4, 6, new int[][]{
                {0, 0}, {1, 1}, {2, 3}
        }, new int[][]{
                {0, 1}, {2, 2}, {1, 4}
        }));
    }

    class Solution {
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            Map<Integer, TreeSet<Integer>> rgs = new HashMap<>(), cgs = new HashMap<>();
            Map<Integer, TreeSet<Integer>> rws = new HashMap<>(), cws = new HashMap<>();

            for (int[] g : guards) {
                int r = g[0], c = g[1];
                rgs.computeIfAbsent(r, x -> new TreeSet<>()).add(c);
                cgs.computeIfAbsent(c, x -> new TreeSet<>()).add(r);
            }

            for (int[] w : walls) {
                int r = w[0], c = w[1];
                rws.computeIfAbsent(r, x -> new TreeSet<>()).add(c);
                cws.computeIfAbsent(c, x -> new TreeSet<>()).add(r);
            }

            TreeSet<Integer> empty = new TreeSet<>();
            int res = 0;
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    TreeSet<Integer> rowW = rws.getOrDefault(r, empty), colW = cws.getOrDefault(c, empty);
                    TreeSet<Integer> rowG = rgs.getOrDefault(r, empty), colG = cgs.getOrDefault(c, empty);

                    if (rowG.contains(c) || rowW.contains(c)) continue;

                    Integer topW = colW.lower(r), topG = colG.lower(r);
                    if (topG != null && (topW == null || topG > topW)) continue;

                    Integer botW = colW.higher(r), botG = colG.higher(r);
                    if (botG != null && (botW == null || botG < botW)) continue;

                    Integer leftW = rowW.lower(c), leftG = rowG.lower(c);
                    if (leftG != null && (leftW == null || leftG > leftW)) continue;

                    Integer rightW = rowW.higher(c), rightG = rowG.higher(c);
                    if (rightG != null && (rightW == null || rightG < rightW)) continue;

                    res++;
                }
            }
            return res;
        }
    }
}
