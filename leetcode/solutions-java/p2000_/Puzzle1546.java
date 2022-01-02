package p2000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 *
 * @author half-dead
 */
public class Puzzle1546 {

    public static void main(String[] args) {
        Solution s = new Puzzle1546().new Solution();
        System.out.println(s.maxNonOverlapping(new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10));
    }

    class Solution {
        public int maxNonOverlapping(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(target, 1);
            int sum = 0, res = 0;
            for (int n : nums) {
                sum += n;
                if (map.containsKey(sum)) {
                    res++;
                    sum = 0;
                    map.clear();
                    map.put(target, 1);
                } else {
                    map.put(sum + target, 1);
                }
            }
            return res;
        }
    }
}
