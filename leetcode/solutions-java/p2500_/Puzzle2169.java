package p2500_;

/**
 * https://leetcode.com/problems/count-operations-to-obtain-zero/
 *
 * @author half-dead
 */
public class Puzzle2169 {

    class Solution {
        public int countOperations(int x, int y) {
            if (x == 0 || y == 0) return 0;
            int max = Math.max(x, y), min = Math.min(x, y);
            return max / min + countOperations(max % min, min);
        }
    }
}
