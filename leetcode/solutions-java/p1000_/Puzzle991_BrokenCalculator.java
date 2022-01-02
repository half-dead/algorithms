package p1000_;

/**
 * https://leetcode.com/problems/broken-calculator/
 *
 * @author half-dead
 */
public class Puzzle991_BrokenCalculator {
    class Solution {
        public int brokenCalc(int x, int y) {
            int count = 0;
            while (y > x) {
                count++;
                y = y % 2 == 0 ? y / 2 : y + 1;
            }
            return count + x - y;
        }
    }

    // 1 line recursive solution
    class Solution2 {
        public int brokenCalc(int x, int y) {
            return x >= y ? x - y : 1 + y % 2 + brokenCalc(x, (y + 1) / 2);
        }
    }
}
