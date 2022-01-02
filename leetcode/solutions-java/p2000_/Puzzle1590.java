package p2000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/make-sum-divisible-by-p/
 *
 * @author half-dead
 */
public class Puzzle1590 {

    public static void main(String[] args) {
        Solution s = new Puzzle1590().new Solution();
        System.out.println(s.minSubarray(new int[]{3, 1, 4, 2}, 6));
        System.out.println(s.minSubarray(new int[]{6, 3, 5, 2}, 9));
        System.out.println(s.minSubarray(new int[]{1, 2, 3}, 3));
        System.out.println(s.minSubarray(new int[]{1, 2, 3}, 7));
        System.out.println(s.minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3));
    }

    class Solution {
        public int minSubarray(int[] nums, int p) {
            int len = nums.length, curr = 0, need = 0, min = len;
            for (int num : nums) need = (need + num) % p;

            if (need == 0) {
                return 0;
            }

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for (int i = 0; i < len; i++) {
                curr = (curr + nums[i]) % p;
                map.put(curr, i);
                min = Math.min(min, i - map.getOrDefault((curr - need + p) % p, -len));
            }

            return min == len ? -1 : min;
        }
    }
}
