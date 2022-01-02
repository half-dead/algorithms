package p0500_;

// Given numRows, generate the first numRows of Pascal's triangle.
//
// For example, given numRows = 5,
// Return
// [
//       [1],
//      [1,1],
//     [1,2,1],
//    [1,3,3,1],
//   [1,4,6,4,1]
// ]

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Puzzle118_PascalTriangle {
    public static void main(String[] args) {
        Puzzle118_PascalTriangle p = new Puzzle118_PascalTriangle();
        Solution solution = p.new Solution();
        List<List<Integer>> generate = solution.generate(3);
    }

    public class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>(numRows);
            int row = 1;
            while (row <= numRows) {
                if (row <= 2) {
                    List<Integer> list = new ArrayList<>(row);
                    for (int i = 0; i < row; i++) {
                        list.add(1);
                    }
                    result.add(list);
                } else {
                    List<Integer> list = new ArrayList<>();
                    List<Integer> prev = result.get(row - 2);
                    list.add(1);
                    for (int i = 0, j = 1; j < prev.size(); i++, j++) {
                        list.add(prev.get(i) + prev.get(j));
                    }
                    list.add(1);
                    result.add(list);
                }
                row++;
            }
            return result;
        }
    }

}
