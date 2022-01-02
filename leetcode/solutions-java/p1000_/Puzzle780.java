package p1000_;

/**
 * https://leetcode.com/problems/reaching-points/
 *
 * @author half-dead
 */
public class Puzzle780 {

    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            while (sx < tx && sy < ty) {
                if (tx > ty) tx %= ty;
                else ty %= tx;
            }
            return (sx == tx && sy <= ty && (ty - sy) % tx == 0) ||
                    (sy == ty && sx <= tx && (tx - sx) % ty == 0);
        }
    }
}
