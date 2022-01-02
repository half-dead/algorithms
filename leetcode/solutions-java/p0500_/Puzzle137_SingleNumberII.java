package p0500_;

// Given an array of integers, every element appears three times except for one. Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/single-number-ii/
 */
public class Puzzle137_SingleNumberII {

    public static void main(String[] args) {
        Puzzle137_SingleNumberII puzzle137 = new Puzzle137_SingleNumberII();
        Solution2 solution2 = puzzle137.new Solution2();
//        solution2.singleNumber(new int[]{1, 3, 8, 3, 2, 8, 1, 1, 8, 3});
        solution2.singleNumber(new int[]{1, 3, 3, 2, 1, 1, 3});

    }

    public class Solution {
        public int singleNumber(int[] a) {
            Arrays.sort(a);
            int index = a.length - 1;
            while (index > 0) {
                if (a[index] == a[index - 1]) {
                    index -= 3;
                } else {
                    return a[index];
                }
            }
            return a[0];
        }
    }

    /**
     * I can't understand.
     */
    public class Solution2 {
        public int singleNumber(int[] a) {
            int n1 = 0, n2 = 0, n3 = 0;
            for (int i : a) {
                n3 = n2 & i;
                n2 = (n2 | (n1 & i)) & (~n3);
                n1 = (n1 | i) & (~n3);
                System.out.println("i=" + n1 + " ,n2=" + n2 + ", n3=" + n3);
            }
            return n1;
        }
    }
}
