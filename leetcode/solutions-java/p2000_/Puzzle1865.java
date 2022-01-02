package p2000_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/finding-pairs-with-a-certain-sum/
 *
 * @author half-dead
 */
public class Puzzle1865 {

    class FindSumPairs {
        private int[] a;
        private int[] b;
        private Map<Integer, Integer> map = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            a = nums1;
            b = nums2;
            for (int n : nums2) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            Arrays.sort(a);
        }

        public void add(int index, int val) {
            int old = b[index];
            b[index] += val;
            map.put(old, map.get(old) - 1);
            map.put(b[index], map.getOrDefault(b[index], 0) + 1);
        }

        public int count(int tot) {
            int res = 0;
            for (int n : a) {
                if (tot <= n) {
                    break;
                }
                res += map.getOrDefault(tot - n, 0);
            }
            return res;
        }
    }

}
