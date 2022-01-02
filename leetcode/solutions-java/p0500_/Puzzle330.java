package p0500_;

/**
 * https://leetcode.com/problems/patching-array/
 *
 * @author half-dead
 */
public class Puzzle330 {

    public static void main(String[] args) {
        Solution s = new Puzzle330().new Solution();
//        System.out.println(s.minPatches(new int[]{1, 3}, 6));
//        System.out.println(s.minPatches(new int[]{1, 5, 10}, 20));
//        System.out.println(s.minPatches(new int[]{1, 2, 2}, 5));
//        System.out.println(s.minPatches(new int[]{1, 7, 21, 31, 34, 37, 40, 43, 49, 87, 90, 92, 93, 98, 99}, 12));
        System.out.println(s.minPatches(new int[]{1, 2, 2, 6, 34, 38, 41, 44, 47, 47, 56, 59, 62, 73, 77, 83, 87, 89, 94}, 20));
    }

    class Solution {
        public int minPatches(int[] nums, int n) {
            long m = 0L;
            int ans = 0, i = 0, len = nums.length;
            while (m < n) {
                if (i == len || m < nums[i] - 1) {
                    ans++;
                    m = m * 2 + 1;
                } else {
                    m += nums[i++];
                }
            }
            return ans;
        }
    }
}
