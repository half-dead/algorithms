package p0500_;

// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
// The replacement must be in-place, do not allocate extra memory.
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//   1,2,3 �� 1,3,2
//   3,2,1 �� 1,2,3
//   1,1,5 �� 1,5,1

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class Puzzle031_NextPermutation {

    public static void main(String[] args) {
        Puzzle031_NextPermutation p = new Puzzle031_NextPermutation();
        Solution solution = p.new Solution();
        int[] num = new int[]{1, 5, 1};
        solution.nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }

    public class Solution {
        public void nextPermutation(int[] num) {
            if (num.length < 2) {
                return;
            }
            int j = num.length - 1;
            while (j > 0) {
                if (num[j] > num[j - 1]) break;
                j--;
            }
            if (j == 0) {
                Arrays.sort(num);
                return;
            }
            int i = j - 1;
            j = num.length - 1;
            while (num[i] >= num[j]) {
                j--;
            }
            num[i] ^= num[j];
            num[j] ^= num[i];
            num[i] ^= num[j];
            Arrays.sort(num, ++i, num.length);
        }
    }
}
