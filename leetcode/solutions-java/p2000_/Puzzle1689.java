package p2000_;

/**
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 *
 * @author half-dead
 */
public class Puzzle1689 {

    class Solution {
        public int minPartitions(String n) {
            int max = 1;
            for (int i = 0; i < n.length(); i++) max = Math.max(max, n.charAt(i) - '0');
            return max;
        }
    }

}
