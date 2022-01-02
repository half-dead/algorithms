package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1785 {

    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            long sum = 0;
            for (int n : nums) sum += n;
            return (int) ((Math.abs(sum - goal) + limit - 1) / limit);
        }
    }
}
