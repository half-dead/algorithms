package p0500_;

// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/majority-element/
 */
public class Puzzle169_MajorityElement {

    // O(n)
    public class Solution {
        public int majorityElement(int[] num) {
            int major = num[0], count = 1;
            for (int i = 1; i < num.length; i++) {
                if (count == 0) {
                    major = num[i];
                    count++;
                } else if (major == num[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            return major;
        }
    }

    // O(nlogn)
    public class Solution2 {
        public int majorityElement(int[] num) {
            Arrays.sort(num);
            return num[num.length / 2];
        }
    }
}
