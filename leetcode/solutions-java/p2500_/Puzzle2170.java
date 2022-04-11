package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-the-array-alternating/
 *
 * @author half-dead
 */
public class Puzzle2170 {
    class Solution {
        public int minimumOperations(int[] nums) {
            Map<Integer, Integer> even = new HashMap<>(), odd = new HashMap<>();

            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                Map<Integer, Integer> m = i % 2 == 0 ? even : odd;
                m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            }

            int[] evenMax = cal(even), oddMax = cal(odd);

            int maxRetain = Math.max(oddMax[1] + evenMax[3], evenMax[1] + oddMax[3]);
            if (evenMax[0] != oddMax[0]) maxRetain = oddMax[1] + evenMax[1];

            return n - maxRetain;
        }

        /**
         * return an 4-length array:
         * [max, freq of max, second-max, freq of second-max]
         * <p>
         * Notice that:
         * max and second-max may be equal, but that will not affect the answer.
         */
        int[] cal(Map<Integer, Integer> m) {
            int[] res = new int[4];
            for (Map.Entry<Integer, Integer> e : m.entrySet()) {
                int key = e.getKey(), value = e.getValue();

                if (value > res[1]) {
                    res[2] = res[0];
                    res[3] = res[1];
                    res[0] = key;
                    res[1] = value;
                } else if (value > res[3]) {
                    res[2] = key;
                    res[3] = value;
                }
            }
            return res;
        }
    }
}
