package p2500_;

/**
 * https://leetcode.com/problems/count-the-hidden-sequences/
 *
 * @author half-dead
 */
public class Puzzle2145 {

    class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            long dis = 0, min = 0, max = 0;
            for (int x : differences) {
                dis += x;
                max = Math.max(max, dis);
                min = Math.min(min, dis);
            }
            return (int) Math.max(0, (long) (upper - lower + 1) - max + min);
        }
    }
}
