package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-gap/
 *
 * @author half-dead
 */
public class Puzzle164_MaximumGap {

    public static void main(String[] args) {
        Puzzle164_MaximumGap p = new Puzzle164_MaximumGap();
        Solution s = p.new Solution();
        int[] nums = {
                1, 1, 1, 1
        };
        System.out.println(s.maximumGap(nums));
    }

    // Buckets
    class Solution {
        public int maximumGap(int[] nums) {
            if (nums.length < 2) return 0;

            int min = nums[0], max = nums[0];
            for (int n : nums) {
                min = Math.min(min, n);
                max = Math.max(max, n);
            }

            int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
            int bucketNum = (max - min) / (bucketSize) + 1;
            Bucket[] buckets = new Bucket[bucketNum];
            for (int n : nums) {
                int idx = (n - min) / bucketSize;
                if (buckets[idx] == null) buckets[idx] = new Bucket();
                buckets[idx].put(n);
            }

            int prev = min, gap = 0;
            for (Bucket bucket : buckets) {
                if (bucket == null) continue;
                gap = Math.max(gap, bucket.min - prev);
                prev = bucket.max;
            }
            return gap;
        }

        class Bucket {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            void put(int n) {
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
        }
    }

    class Solution2 {
        public int maximumGap(int[] nums) {
            if (nums == null || nums.length < 2) return 0;

            int max = 0;
            for (int n : nums) max = Math.max(n, max);

            int exp = 1, radix = 10;
            int[] array = new int[nums.length];
            while (max / exp > 0) {
                int[] count = new int[radix];
                for (int num : nums) count[(num / exp) % radix]++;
                for (int i = 1; i < radix; i++) count[i] += count[i - 1];

                for (int i = nums.length - 1; i >= 0; i--) {
                    int mod = (nums[i] / exp) % radix;
                    array[--count[mod]] = nums[i];
                }
                System.arraycopy(array, 0, nums, 0, nums.length);
                exp *= radix;
            }
            int gap = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                gap = Math.max(nums[i + 1] - nums[i], gap);
            }
            return gap;
        }
    }

    class Solution3 {
        public int maximumGap(int[] nums) {
            Arrays.sort(nums);
            int gap = 0;
            for (int i = 1; i < nums.length; i++) {
                gap = Math.max(gap, nums[i] - nums[i - 1]);
            }
            return gap;
        }
    }
}
