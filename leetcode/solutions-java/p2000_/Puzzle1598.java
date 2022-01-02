package p2000_;

/**
 * https://leetcode.com/problems/crawler-log-folder/
 *
 * @author half-dead
 */
public class Puzzle1598 {

    class Solution {
        public int minOperations(String[] logs) {
            int depth = 0;
            for (String log : logs) {
                if (log.equals("../")) {
                    depth = Math.max(depth - 1, 0);
                } else if (log.equals("./")) {

                } else {
                    depth++;
                }
            }
            return depth;
        }
    }
}
