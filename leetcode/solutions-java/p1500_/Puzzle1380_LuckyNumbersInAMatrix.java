package p1500_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 *
 * @author half-dead
 */
public class Puzzle1380_LuckyNumbersInAMatrix {
    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;
            Set<Integer> set = new HashSet<>(rows);
            for (int r = 0; r < rows; r++) {
                int min = Integer.MAX_VALUE;
                for (int c = 0; c < cols; c++) min = Math.min(matrix[r][c], min);
                set.add(min);
            }

            List<Integer> list = new ArrayList<>();
            for (int c = 0; c < cols; c++) {
                int max = 0;
                for (int r = 0; r < rows; r++) max = Math.max(matrix[r][c], max);
                if (set.contains(max)) {
                    list.add(max);
                    break;
                }
            }
            return list;
        }
    }
}
