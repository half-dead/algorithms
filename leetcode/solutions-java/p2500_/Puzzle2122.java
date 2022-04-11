package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/recover-the-original-array/
 *
 * @author half-dead
 */
public class Puzzle2122 {

    public static void main(String[] args) {
        Solution s = new Puzzle2122().new Solution();
        System.out.println(Arrays.toString(s.recoverArray(new int[]{
                11, 6, 3, 4, 8, 7, 8, 7, 9, 8, 9, 10, 10, 2, 1, 9
        })));
    }

    // sorting, greedy
    class Solution {
        public int[] recoverArray(int[] nums) {
            int n = nums.length, m = n >> 1;

            Arrays.sort(nums);

            // 依据：
            // 1. 排序后, nums[i] - k 和 nums[i] + k之间的跨度不会超过m
            // 2. 最小元素一定来自于nums[x] - k，最大元素一定来自于nums[y] + k
            // 根据以上两点，得到一个可能的k的集合，然后穷举找到正确解即可。
            Set<Integer> kset = new HashSet<>(), other = new HashSet<>();
            for (int i = 1, j = m - 1; i <= m; i++, j++) {
                int d1 = nums[i] - nums[0], d2 = nums[n - 1] - nums[j];
                if (d1 % 2 == 0) kset.add(d1 >> 1);
                if (d2 % 2 == 0) other.add(d2 >> 1);
            }
            kset.retainAll(other);

            Map<Integer, Integer> map = new HashMap<>();
            for (int v : nums) {
                map.put(v, map.getOrDefault(v, 0) + 1);
            }

            for (int k : kset) {
                int[] res = check(map, k, m);
                if (res != null) return res;
            }
            return null;
        }

        int[] check(Map<Integer, Integer> map, int k, int m) {
            TreeMap<Integer, Integer> tm = new TreeMap<>(map);
            int[] res = new int[m];
            int i = 0;
            while (tm.size() > 1) {
                int lo = tm.firstKey();
                int locnt = tm.remove(lo) - 1;

                int hi = lo + k + k;
                if (tm.containsKey(hi)) {
                    int hicnt = tm.remove(hi) - 1;
                    res[i++] = lo + k;
                    if (locnt > 0) tm.put(lo, locnt);
                    if (hicnt > 0) tm.put(hi, hicnt);
                } else {
                    break;
                }
            }
            return i == m ? res : null;
        }
    }
}
