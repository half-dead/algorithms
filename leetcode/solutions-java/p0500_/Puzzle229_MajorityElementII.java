package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/
 *
 * @author half-dead
 */
public class Puzzle229_MajorityElementII {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int a = 0, b = 0, ca = 0, cb = 0;
            for (int n : nums) {
                if (n == a) {
                    ca++;
                } else if (n == b) {
                    cb++;
                } else if (ca == 0) {
                    a = n;
                    ca = 1;
                } else if (cb == 0) {
                    b = n;
                    cb = 1;
                } else {
                    ca--;
                    cb--;
                }
            }

            ca = 0;
            cb = 0;
            for (int n : nums) {
                if (n == a) {
                    ca++;
                } else if (n == b) {
                    cb++;
                }

            }

            int oneThird = nums.length / 3;
            List<Integer> list = new ArrayList<>();
            if (ca > oneThird) {
                list.add(a);
            }
            if (cb > oneThird) {
                list.add(b);
            }
            return list;
        }
    }

}
