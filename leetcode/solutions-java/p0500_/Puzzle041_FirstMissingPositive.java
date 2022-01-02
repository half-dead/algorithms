package p0500_;

// Given an unsorted integer array, find the first missing positive integer.
//
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
//
// Your algorithm should run in O(n) time and uses constant space.

/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class Puzzle041_FirstMissingPositive {

    public static void main(String[] args) {
        Solution s = new Puzzle041_FirstMissingPositive().new Solution();
//        System.out.println(s.firstMissingPositive(new int[]{}));
//        System.out.println(s.firstMissingPositive(new int[]{1}));
        System.out.println(s.firstMissingPositive(new int[]{1, 1}));

    }

    class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; ) {
                while (i < nums.length && nums[i] == i + 1) {
                    i++;
                }
                if (i == nums.length) break;

                int dest = nums[i] - 1;
                if (nums[i] > 0 && nums[i] < i + 1 && nums[i] != nums[dest]) {
                    int temp = nums[dest];
                    nums[dest] = nums[i];
                    nums[i] = temp;
                } else {
                    i++;
                }
            }
            int i = 0;
            for (; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return i + 1;
        }
    }
}
