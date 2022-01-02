/*
https://leetcode.com/problems/triangle/description/

Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
    Bonus point if you are able to do this using only O(n) extra space,
    where n is the total number of rows in the triangle.
 */

package p0500_;

import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle120_Triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> prow = triangle.get(i - 1);
                List<Integer> row = triangle.get(i);
                for (int j = 0; j < row.size(); j++) {
                    if (j == 0) {
                        row.set(j, row.get(j) + prow.get(j));
                    } else if (j == row.size() - 1) {
                        row.set(j, row.get(j) + prow.get(j - 1));
                    } else {
                        row.set(j, row.get(j) + Math.min(prow.get(j - 1), prow.get(j)));
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i : triangle.get(triangle.size() - 1)) {
                if (res > i) {
                    res = i;
                }
            }
            return res;
        }
    }
}
