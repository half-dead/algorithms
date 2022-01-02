package p1500_;

import java.util.*;

/**
 * https://leetcode.com/problems/online-majority-element-in-subarray/
 *
 * @author half-dead
 */
public class Puzzle1157 {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1};
        MajorityChecker mc = new Puzzle1157().new MajorityChecker(arr);
        System.out.println(mc.query(3, 12, 6));
    }

    class MajorityChecker {

        int[] nums;
        Map<Integer, TreeSet<Integer>> ts;

        public MajorityChecker(int[] arr) {
            nums = arr;
            ts = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                ts.computeIfAbsent(num, x -> new TreeSet<>()).add(i);
            }
        }

        public int query(int left, int right, int threshold) {
            int total = right - left + 1, remain = total;
            Set<Integer> checked = new HashSet<>();
            for (int i = left; i <= right; i++) {
                int num = nums[i];
                if (!checked.add(num)) continue;

                int cnt = ts.get(num).subSet(left, true, right, true).size();
                if (cnt >= threshold) return num;

                remain -= cnt;
                if (remain < threshold) break;
            }
            return -1;
        }
    }
}
