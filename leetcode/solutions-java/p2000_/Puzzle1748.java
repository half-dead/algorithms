package p2000_;

/**
 * https://leetcode.com/problems/sum-of-unique-elements/
 *
 * @author half-dead
 */
public class Puzzle1748 {

    class Solution {
        public int sumOfUnique(int[] nums) {
            int[] freq = new int[101];
            for (int n : nums) freq[n]++;
            int sum = 0;
            for (int i = 1; i < 101; i++) if (freq[i] == 1) sum += i;
            return sum;
        }
    }
}
