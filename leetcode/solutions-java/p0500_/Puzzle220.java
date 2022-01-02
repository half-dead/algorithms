package p0500_;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 *
 * @author half-dead
 */
public class Puzzle220 {
    public static void main(String[] args) {


        long l1 = (long) Integer.MAX_VALUE - Integer.MIN_VALUE;
        System.out.println(l1);

        Solution s = new Puzzle220().new Solution();
    }

    // Bucket, O(N)
    public class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int len = nums.length;
            if (len < 2 || k < 1 || t < 0) return false;

            long[] m = new long[len];
            for (int i = 0; i < nums.length; i++) m[i] = (long) nums[i] - Integer.MIN_VALUE;

            long bucketSize = (long) t + 1;
            Map<Long, Long> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                if (i > k) map.remove(m[i - k - 1] / bucketSize);

                long bucket = m[i] / bucketSize;
                if (map.containsKey(bucket)
                        || (map.containsKey(bucket - 1) && m[i] - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - m[i] <= t))
                    return true;

                map.put(bucket, m[i]);
            }
            return false;
        }
    }

    // TreeMap, O(N * logk)
    class TreeMapSolution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int len = nums.length;
            if (len < 2 || k < 1 || t < 0) return false;

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < len; i++) {
                if (i - k - 1 >= 0) remove(map, nums[i - k - 1]);

                int left = nums[i] < (t + Integer.MIN_VALUE) ? Integer.MIN_VALUE : nums[i] - t;
                int right = (nums[i] > Integer.MAX_VALUE - t) ? Integer.MAX_VALUE : nums[i] + t;
                if (map.subMap(left, true, right, true).size() > 0)
                    return true;

                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            return false;
        }

        void remove(Map<Integer, Integer> map, int key) {
            int cnt = map.get(key);
            if (cnt == 1) map.remove(key);
            else map.put(key, cnt - 1);
        }
    }
}
