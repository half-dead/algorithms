/*
https://leetcode.com/problems/permutation-sequence/description/

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
Given n and k, return the kth permutation sequence.

Note:
    Given n will be between 1 and 9 inclusive.
    Given k will be between 1 and n! inclusive.

Example 1:
    Input: n = 3, k = 3
    Output: "213"
Example 2:
    Input: n = 4, k = 9
    Output: "2314"
 */

package p0500_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle060_PermutationSequence {

    public static void main(String[] args) {
        Solution s = new Puzzle060_PermutationSequence().new Solution();
        System.out.println(s.getPermutation(3, 3));
        System.out.println(s.getPermutation(4, 9));
        System.out.println(s.getPermutation(9, 5623));
    }

    class Solution {
        public String getPermutation(int n, int k) {
            int[] factorials = new int[n + 1];
            factorials[1] = 1;
            for (int i = 2; i <= n; i++) {
                factorials[i] = i * factorials[i - 1];
            }
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }

            StringBuilder builder = new StringBuilder();
            int fIndex = n - 1;
            int baseIndex = 0;
            while (k > 0) {
                if (k == 1) {
                    for (int i = baseIndex; i < nums.length; i++) {
                        builder.append(nums[i]);
                    }
                    break;
                }
                int numIndex = baseIndex;
                while (k > factorials[fIndex]) {
                    k -= factorials[fIndex];
                    numIndex++;
                }
                if (numIndex != baseIndex) {
                    int temp = nums[numIndex];
                    nums[numIndex] = nums[baseIndex];
                    nums[baseIndex] = temp;
                }
                builder.append(nums[baseIndex]);
                baseIndex++;
                fIndex--;
                Arrays.sort(nums, baseIndex, nums.length);
            }
            return builder.toString();
        }
    }

    // not my solution
    class Solution2 {
        public String getPermutation(int n, int k) {
            StringBuilder sb = new StringBuilder();
            boolean[] used = new boolean[n];

            k = k - 1;
            int factor = 1;
            for (int i = 1; i < n; i++) {
                factor *= i;
            }

            for (int i = 0; i < n; i++) {
                int index = k / factor;
                k = k % factor;
                for (int j = 0; j < n; j++) {
                    if (!used[j]) {
                        if (index == 0) {
                            used[j] = true;
                            sb.append((char) ('0' + j + 1));
                            break;
                        } else {
                            index--;
                        }
                    }
                }
                if (i < n - 1) {
                    factor = factor / (n - 1 - i);
                }
            }
            return sb.toString();
        }
    }
}
