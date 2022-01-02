package p2000_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 *
 * @author half-dead
 */
public class Puzzle1863 {


    // https://leetcode.com/problems/sum-of-all-subset-xor-totals/discuss/1211177/Simple-trick-oror-4-lines-of-code-oror-Explained!!
    class Solution {
        public int subsetXORSum(int[] nums) {
            int xor = 0;
            for (int n : nums) xor |= n;
            return xor * (1 << (nums.length - 1));
        }
    }

    // BFS
    class BfsSolution {
        public int subsetXORSum(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int res = 0;
            for (int n : nums) {
                int sz = list.size();
                for (int i = 0; i < sz; i++) {
                    int xor = list.get(i) ^ n;
                    list.add(xor);
                    res += xor;
                }
                list.add(n);
                res += n;
            }
            return res;
        }
    }
}
