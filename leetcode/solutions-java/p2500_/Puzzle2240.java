package p2500_;

/**
 * https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/
 *
 * @author half-dead
 */
public class Puzzle2240 {

    class Solution {
        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            long res = 0L;
            for (int a = 0; a <= total / cost1; a++) {
                int rest = total - cost1 * a;
                res += rest / cost2 + 1;
            }
            return res;
        }
    }
}
