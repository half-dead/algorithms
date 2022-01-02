package p0500_;

// Given an index k, return the kth row of the Pascal's triangle.
//
// For example, given k = 3,
// Return [1,3,3,1].

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class Puzzle119_PascalTriangleII {

    public static void main(String[] args) {
        Puzzle119_PascalTriangleII p = new Puzzle119_PascalTriangleII();
        Solution solution = p.new Solution();
        List<Integer> row = solution.getRow(5);
        System.out.println(row);
    }

    public class Solution {
        public List<Integer> getRow(int rowIndex) {
            int[] ints = new int[rowIndex + 1];
            ints[0] = 1;
            for (int i = 0; i <= rowIndex; i++) {
                for (int j = i; j > 0; j--) {
                    ints[j] = ints[j] + ints[j - 1];
                }
            }
            List<Integer> list = new ArrayList<>(ints.length);
            for (int i = 0; i < ints.length; i++) {
                list.add(ints[i]);
            }
            return list;
        }
    }
}
