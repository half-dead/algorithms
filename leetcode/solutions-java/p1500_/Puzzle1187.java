package p1500_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/make-array-strictly-increasing/
 *
 * @author half-dead
 */
public class Puzzle1187 {

    public static void main(String[] args) {
        Solution s = new Puzzle1187().new Solution();
        System.out.println(s.makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{4, 3, 1}));
    }

    // dp, O(N^2 logM) time, O(N) space
    class Solution {
        public int makeArrayIncreasing(int[] nums, int[] b) {
            Arrays.sort(b);
            int len = b.length;

            // dp[k,v] means we need at least v swaps to make the array strictly increasing, and max(arr)=k
            Map<Integer, Integer> dp1 = new HashMap<>(), dp2;
            dp1.put(-1, 0);

            for (int n : nums) {
                dp2 = new HashMap<>();

                for (int max : dp1.keySet()) {
                    int swap = dp1.get(max);
                    if (max < n) dp2.put(n, Math.min(swap, dp2.getOrDefault(n, swap)));

                    int pos = Arrays.binarySearch(b, max + 1);
                    if (pos < 0) pos = -pos - 1;
                    if (pos < len) {
                        swap++;
                        int next = b[pos];
                        dp2.put(next, Math.min(swap, dp2.getOrDefault(next, swap)));
                    }
                }
                if (dp2.size() == 0) return -1;
                dp1 = dp2;
            }

            return dp1.values().stream().min(Comparator.comparingInt(x -> x)).get();
        }
    }
}
