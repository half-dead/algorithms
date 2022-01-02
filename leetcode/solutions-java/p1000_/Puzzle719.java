package p1000_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 *
 * @author half-dead
 */
public class Puzzle719 {

    public static void main(String[] args) {
        Solution s = new Puzzle719().new Solution();
        System.out.println(s.smallestDistancePair(new int[]{1, 6, 1}, 3));
    }

    // sort + binary search + sliding window
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int lo = 0, hi = nums[nums.length - 1];
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (count(nums, mid) < k) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }

        int count(int[] nums, int mid) {
            int res = 0, n = nums.length, left = 0, right = 0;
            while (left < n) {
                int target = nums[left] + mid;
                while (right < n && nums[right] <= target) right++;
                res += right - ++left;
            }
            return res;
        }
    }

    // binary search + bucket sort.
    class Solution1 {
        public int smallestDistancePair(int[] nums, int k) {
            int max = 0;
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
                max = Math.max(max, n);
            }

            int[] buckets = new int[max + 1];
            for (int n : nums) buckets[n]++;
            for (int i = 1; i <= max; i++) buckets[i] += buckets[i - 1];

            int lo = 0, hi = max;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                int cnt = count(set, buckets, mid);
                if (cnt < k) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }

        int count(Set<Integer> set, int[] buckets, int mid) {
            int res = 0;
            for (int x : set) {
                int loCnt = x == 0 ? buckets[0] : (buckets[x] - buckets[x - 1]);
                int hiCnt = buckets[Math.min(buckets.length - 1, x + mid)] - buckets[x];
                res += loCnt * hiCnt + loCnt * (loCnt - 1) / 2;
            }
            return res;
        }
    }
}
