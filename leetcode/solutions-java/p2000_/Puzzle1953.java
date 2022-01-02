package p2000_;

/**
 * https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
 *
 * @author half-dead
 */
public class Puzzle1953 {

    class Solution {
        public long numberOfWeeks(int[] milestones) {
            long sum = 0L;
            int max = 0;
            for (int ms : milestones) {
                sum += ms;
                max = Math.max(max, ms);
            }
            if (sum - max + 1 < max) {
                return 2 * (sum - max) + 1;
            } else {
                return sum;
            }
        }
    }
}
