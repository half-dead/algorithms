package p2000_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/minimum-absolute-sum-difference/
 *
 * @author half-dead
 */
public class Puzzle1818 {

    public static void main(String[] args) {
        Solution s = new Puzzle1818().new Solution();
        System.out.println(s.minAbsoluteSumDiff(
                new int[]{1, 10, 4, 4, 2, 7},
                new int[]{9, 3, 5, 1, 7, 4}));
    }

    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int len = nums1.length, max = 0;

            long asd = 0L;
            for (int i = 0; i < len; i++) {
                asd += Math.abs(nums1[i] - nums2[i]);
            }
            if (asd == 0L) return 0;

            int[] copy = Arrays.copyOf(nums1, len);
            Arrays.sort(copy);

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                Integer cache = map.get(nums2[i]);
                if (cache == null) {
                    int pos = Arrays.binarySearch(copy, nums2[i]);
                    if (pos >= 0) {
                        cache = 0;
                    } else {
                        pos = -pos - 1;
                        if (pos == len || (pos > 0 && (nums2[i] << 1) < (copy[pos - 1] + copy[pos]))) {
                            pos--;
                        }
                        cache = Math.abs(nums2[i] - copy[pos]);
                    }
                    map.put(nums2[i], cache);
                }
                max = Math.max(max, Math.abs(nums1[i] - nums2[i]) - cache);
            }
            return (int) ((asd - max) % 1000000007);
        }
    }

    class Solution1 {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int len = nums1.length;

            long asd = 0L;
            TreeSet<Integer> copy = new TreeSet<>();
            for (int i = 0; i < len; i++) {
                asd += Math.abs(nums1[i] - nums2[i]);
                copy.add(nums1[i]);
            }
            if (asd == 0L) {
                return 0;
            }

            int max = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                Integer cache = map.get(nums2[i]);
                if (cache == null) {
                    Integer ceil = copy.ceiling(nums2[i]), floor = copy.floor(nums2[i]);
                    cache = Math.min(ceil == null ? Integer.MAX_VALUE : Math.abs(ceil - nums2[i]),
                            floor == null ? Integer.MAX_VALUE : Math.abs(floor - nums2[i]));
                    map.put(nums2[i], cache);
                }
                max = Math.max(max, Math.abs(nums1[i] - nums2[i]) - cache);
            }

            asd -= max;
            return (int) (asd % 1000000007);
        }
    }
}
