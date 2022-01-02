package p0500_;

/**
 * https://leetcode.com/problems/total-hamming-distance/
 *
 * @author half-dead
 */
public class Puzzle477_TotalHammingDistance {
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                int bitCount = 0, m = 1 << i;
                for (int n : nums) {
                    if ((n & m) == 0) {
                        bitCount++;
                    }
                }
                count += bitCount * (nums.length - bitCount);
            }
            return count;
        }
    }

    class StupidSolution {
        public int totalHammingDistance(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[i] != nums[j]) {
                        int xor = nums[i] ^ nums[j];
                        while (xor > 0) {
                            if ((xor & 1) != 0) {
                                count++;
                            }
                            xor >>= 1;
                        }
                    }
                }
            }
            return count;
        }
    }
}
