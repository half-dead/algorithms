package p1000_;

/**
 * https://leetcode.com/problems/array-nesting/
 *
 * @author half-dead
 */
public class Puzzle565_ArrayNesting {

    public static void main(String[] args) {
        Puzzle565_ArrayNesting p = new Puzzle565_ArrayNesting();
        Solution s = p.new Solution();
        int r = s.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2});
        System.out.println(r);
    }

    class Solution {
        public int arrayNesting(int[] nums) {
            int result = 1;
            for (int i = 0; i < nums.length; i++) {
                int j = i, count = 0;
                while (nums[j] >= 0 && nums[j] != j) {
                    int m = nums[j];
                    nums[j] = -1;
                    j = m;
                    count++;
                }
                result = Math.max(result, count);
            }
            return result;
        }
    }
}
