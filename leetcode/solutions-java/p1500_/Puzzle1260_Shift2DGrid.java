package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shift-2d-grid/
 *
 * @author half-dead
 */
public class Puzzle1260_Shift2DGrid {
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();

            int rows = grid.length, cols = grid[0].length, area = rows * cols;
            k = (area - (k % area)) % (area);
            int r = k / cols, c = k % cols, i = 0;
            while (i++ < area) {
                temp.add(grid[r][c]);
                if (++c == cols) {
                    c = 0;
                    if (++r == rows) r = 0;
                }
                if (temp.size() == cols) {
                    result.add(temp);
                    temp = new ArrayList<>();
                }
            }
            return result;
        }
    }
}
