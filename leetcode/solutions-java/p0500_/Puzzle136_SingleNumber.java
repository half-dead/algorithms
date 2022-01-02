package p0500_;

// Given an array of integers, every element appears twice except for one. Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/single-number/
 */
public class Puzzle136_SingleNumber {

    public class Solution1 {
        public int singleNumber(int[] a) {
            int len = a.length;
            int result = a[0];
            for (int i = 1; i < len; i++) {
                result ^= a[i];
            }
            return result;
        }
    }

    public class Solution2 {
        public int singleNumber(int[] a) {
            Set<Integer> set = new HashSet<>(a.length / 2 + 1);
            for (int i : a) {
                boolean b = set.add(i);
                if (!b)
                    set.remove(i);
            }
            return set.iterator().next();
        }
    }

    /**
     * O(log2(n) + n)
     */
    public class Solution3 {
        public int singleNumber(int[] a) {
            Arrays.sort(a);
            boolean flag = true;
            int result = 0;
            for (int i : a) {
                result += flag ? i : -i;
                flag = !flag;
            }
            return result;
        }
    }
}
