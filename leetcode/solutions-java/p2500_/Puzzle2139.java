package p2500_;

/**
 * https://leetcode.com/problems/minimum-moves-to-reach-target-score/
 *
 * @author half-dead
 */
public class Puzzle2139 {

    class Solution {
        public int minMoves(int target, int maxDoubles) {
            int res = 0;
            while (target > 1 && maxDoubles > 0) {
                res += target % 2;
                res++;
                target /= 2;
                maxDoubles--;
            }
            return res + target - 1;
        }
    }
}
