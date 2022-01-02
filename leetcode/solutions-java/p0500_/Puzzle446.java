package p0500_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
 *
 * @author half-dead
 */
public class Puzzle446 {

    public static void main(String[] args) {
        Solution s = new Puzzle446().new Solution();
        System.out.println(s.numberOfArithmeticSlices(new int[]{
                5, 7, 3, 5, 3, 1
        }));
    }

    // bottom-up dp, O(N^2) time
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int len = nums.length, ans = 0;
            if (len < 3) return 0;

            List<Map<Integer, Integer>> dp = new ArrayList<>(len);
            for (int to = 0; to < len; to++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int from = 0; from < to; from++) {
                    long diff = (long) nums[to] - nums[from];
                    if (diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE) continue;

                    int step = (int) diff;
                    int temp = dp.get(from).getOrDefault(step, 0);
                    ans += temp;
                    map.put(step, map.getOrDefault(step, 0) + 1 + temp);
                }
                dp.add(map);
            }
            return ans;
        }
    }
}
