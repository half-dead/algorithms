package p2500_;

/**
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 *
 * @author half-dead
 */
public class Puzzle2011 {

    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int v = 0;
            for (String op : operations) {
                if (op.charAt(1) == '+') v++;
                else v--;
            }
            return v;
        }
    }
}
