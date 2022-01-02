package p0500_;

// Given a list of non negative integers, arrange them such that they form the largest number.
//
// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
// Note: The result may be very large, so you need to return a string instead of an integer.

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-number/
 */
public class Puzzle179_LargestNumber {

    public static void main(String[] args) {
        Puzzle179_LargestNumber p = new Puzzle179_LargestNumber();
        Solution solution = p.new Solution();
        int[] nums = new int[]{112, 1122};
        String s = solution.largestNumber(nums);
        System.out.println(s);
    }

    public class Solution {
        public String largestNumber(int[] nums) {
            String[] strings = Arrays.stream(nums).mapToObj(n -> "" + n).toArray(String[]::new);
            Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
            if (strings[0].charAt(0) == '0') return "0";
            return Arrays.stream(strings).reduce((s1, s2) -> s1 + s2).get();
        }
    }
}
