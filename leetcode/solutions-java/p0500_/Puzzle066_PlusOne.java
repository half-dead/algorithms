package p0500_;

// Given a non-negative number represented as an array of digits, plus one to the number.
//
// The digits are stored such that the most significant digit is at the head of the list.

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/plus-one/
 */
public class Puzzle066_PlusOne {

    public static void main(String[] args) {
        Puzzle066_PlusOne puzzle066 = new Puzzle066_PlusOne();
        Solution solution = puzzle066.new Solution();
        int[] ints = solution.plusOne(new int[]{9});
        System.out.println(Arrays.toString(ints));
    }

    public class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length - 1;
            if (digits[len] != 9) {
                digits[len] += 1;
                return digits;
            }

            while (len > -1) {
                if (digits[len] != 9) {
                    digits[len] += 1;
                    break;
                } else {
                    digits[len--] = 0;
                    if (len == -1) {
                        int[] result = new int[digits.length + 1];
                        result[0] = 1;
                        System.arraycopy(digits, 0, result, 1, digits.length);
                        return result;
                    }
                }
            }
            return digits;
        }
    }
}
