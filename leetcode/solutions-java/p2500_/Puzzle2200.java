package p2500_;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
 *
 * @author half-dead
 */
public class Puzzle2200 {
    class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            LinkedList<Integer> res = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != key) continue;
                for (int j = Math.max(0, i - k); j <= Math.min(i + k, nums.length - 1); j++) {
                    if (res.size() == 0 || j > res.peekLast()) {
                        res.addLast(j);
                    }
                }
            }
            return res;
        }
    }
}
