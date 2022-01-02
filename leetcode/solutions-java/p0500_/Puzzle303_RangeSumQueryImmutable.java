package p0500_;

// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
// Example:
// Given nums = [-2, 0, 3, -5, 2, -1]
//
// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3
// Note:
// You may assume that the array does not change.
// There are many calls to sumRange function.

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class Puzzle303_RangeSumQueryImmutable {

    public static void main(String[] args) {
        Puzzle303_RangeSumQueryImmutable p = new Puzzle303_RangeSumQueryImmutable();
        NumArray numArray = p.new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    public class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }

            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if (i == 0)
                return nums[j];

            return nums[j] - nums[i - 1];
        }
    }


}
