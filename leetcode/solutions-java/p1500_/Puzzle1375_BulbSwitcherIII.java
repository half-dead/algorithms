package p1500_;

/**
 * https://leetcode.com/problems/bulb-switcher-iii/
 *
 * @author half-dead
 */
public class Puzzle1375_BulbSwitcherIII {
    class Solution {
        public int numTimesAllBlue(int[] light) {
            int on = 0, blue = 0, right = 0;
            for (int bulb : light) {
                right = Math.max(right, bulb);
                if (++on == right) blue++;
            }
            return blue;
        }
    }
}
