package p2500_;

/**
 * https://leetcode.com/problems/k-divisible-elements-subarrays/
 *
 * @author half-dead
 */
public class Puzzle2261 {

    class Solution {
        public int countDistinct(int[] nums, int k, int p) {
            int n = nums.length, res = 0;
            int left = 0, right = 0, cnt = 0;
            while (right < n) {
                int v = nums[right];
                if (v % p == 0) {
                    cnt++;
                }
                if (cnt <= k) {
                    res += right - left + 1;
                }
                while (cnt > k) {
                    if (nums[left++] % p == 0) {
                        cnt--;
                    }
                }
                right++;
            }
            return res;
        }
    }
}
