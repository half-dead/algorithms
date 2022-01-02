package p0500_;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * @author half-dead
 */
public class Puzzle287_FindTheDuplicateNumber {

    public static void main(String[] args) {
        Solution s = new Puzzle287_FindTheDuplicateNumber().new Solution();
        System.out.println(s.findDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 3}));
    }

    class Solution {
        public int findDuplicate(int[] nums) {
            // Find the intersection point of the two runners.
            int tortoise = nums[0];
            int hare = nums[0];
            do {
                System.out.println("tortoise=" + tortoise + ", hare=" + hare);
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            } while (tortoise != hare);
            System.out.println("tortoise=" + tortoise + ", hare=" + hare);

            // Find the "entrance" to the cycle.
            int ptr1 = nums[0];
            int ptr2 = tortoise;
            while (ptr1 != ptr2) {
                System.out.println("ptr1=" + ptr1 + ", ptr2=" + ptr2);
                ptr1 = nums[ptr1];
                ptr2 = nums[ptr2];
            }
            System.out.println("ptr1=" + ptr1 + ", ptr2=" + ptr2);

            return ptr1;
        }
    }

    class StupidSolution {
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return nums[i];
                    }
                }
            }
            return 0;
        }
    }
}
