package p2500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/
 *
 * @author half-dead
 */
public class Puzzle2089 {

    class Solution {
        public List<Integer> targetIndices(int[] nums, int target) {
            int cnt = 0, start = 0;
            for (int v : nums) {
                if (v == target) cnt++;
                else if (v < target) start++;
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < cnt; i++) result.add(start++);
            return result;
        }
    }
}
