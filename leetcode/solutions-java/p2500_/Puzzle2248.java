package p2500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-multiple-arrays/
 *
 * @author half-dead
 */
public class Puzzle2248 {

    class Solution {
        public List<Integer> intersection(int[][] nums) {
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i <= 1000; i++) {
                int cnt = 0;
                for (int[] row : nums) {
                    for (int x : row) {
                        if (x == i) {
                            cnt++;
                        }
                    }
                }
                if (cnt == nums.length) res.add(i);
            }
            return res;
        }
    }
}
