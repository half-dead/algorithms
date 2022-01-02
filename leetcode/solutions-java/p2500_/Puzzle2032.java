package p2500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/two-out-of-three/
 *
 * @author half-dead
 */
public class Puzzle2032 {

    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int[] mark = new int[101];
            for (int v : nums1) mark[v] |= 1;
            for (int v : nums2) mark[v] |= 2;
            for (int v : nums3) mark[v] |= 4;

            List<Integer> res = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                if ((mark[i] & (mark[i] - 1)) != 0)
                    res.add(i);
            }
            return res;
        }
    }
}
