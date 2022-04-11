package p2500_;

/**
 * https://leetcode.com/problems/divide-array-into-equal-pairs/
 *
 * @author half-dead
 */
public class Puzzle2206 {
    class Solution {
        public boolean divideArray(int[] nums) {
            int[] cnts = new int[501];
            for (int x : nums) cnts[x]++;
            for (int x : cnts) if (x % 2 != 0) return false;
            return true;
        }
    }
}
