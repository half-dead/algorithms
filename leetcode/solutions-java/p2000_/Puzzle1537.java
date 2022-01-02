package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/get-the-maximum-score/
 *
 * @author half-dead
 */
public class Puzzle1537 {

    // two pointers
    class Solution {
        public int maxSum(int[] nums1, int[] nums2) {
            long sum1 = 0L, sum2 = 0L;
            int m = nums1.length, n = nums2.length, i = 0, j = 0;
            while (i < m || j < n) {
                if (i < m && (j == n || nums1[i] < nums2[j])) {
                    sum1 += nums1[i++];
                } else if (i == m || nums2[j] < nums1[i]) {
                    sum2 += nums2[j++];
                } else {
                    // nums1[i] == nums2[j]
                    sum1 = sum2 = Math.max(sum1, sum2) + nums1[i];
                    i++;
                    j++;
                }
            }
            return (int) (Math.max(sum1, sum2) % 1000000007);
        }
    }

    class Solution1 {
        public int maxSum(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            for (int v : nums1) set.add(v);

            List<Integer> common = new ArrayList<>();
            for (int v : nums2) {
                if (set.contains(v)) {
                    common.add(v);
                }
            }
            common.add(100000000);

            Map<Integer, Long> map = new HashMap<>();
            for (int v : common) map.put(v, 0L);


            int i = 0, stop = common.get(i);
            long sum = 0L;
            for (int v : nums1) {
                if (v <= stop) {
                    sum += v;
                } else {
                    map.put(stop, Math.max(sum, map.get(stop)));
                    stop = common.get(++i);
                    sum = v;
                }
            }
            map.put(stop, sum);

            i = 0;
            stop = common.get(i);
            sum = 0L;
            for (int v : nums2) {
                if (v <= stop) {
                    sum += v;
                } else {
                    map.put(stop, Math.max(sum, map.get(stop)));
                    stop = common.get(++i);
                    sum = v;
                }
            }
            map.put(stop, Math.max(sum, map.get(stop)));

            long res = 0L;
            for (long v : map.values()) res += v;
            return (int) (res % 1000000007);
        }
    }
}
