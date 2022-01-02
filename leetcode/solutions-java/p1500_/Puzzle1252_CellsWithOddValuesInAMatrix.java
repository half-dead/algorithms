package p1500_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 *
 * @author half-dead
 */
public class Puzzle1252_CellsWithOddValuesInAMatrix {
    class Solution {
        public int oddCells(int rows, int cols, int[][] indices) {
            Set<Integer> rowSet = new HashSet<>(), colSet = new HashSet<>();
            for (int[] indice : indices) {
                int r = indice[0], c = indice[1];
                if (!rowSet.remove(r)) rowSet.add(r);
                if (!colSet.remove(c)) colSet.add(c);
            }
            return rowSet.size() * cols + colSet.size() * rows - 2 * rowSet.size() * colSet.size();
        }
    }
}
