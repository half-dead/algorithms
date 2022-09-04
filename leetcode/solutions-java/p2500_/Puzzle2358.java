package p2500_;

/**
 * https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/
 *
 * @author half-dead
 */
public class Puzzle2358 {

    class Solution {
        public int maximumGroups(int[] grades) {
            int x = 1, n = grades.length;
            while (x * (x + 1) / 2 <= n) {
                x++;
            }
            return x - 1;
        }
    }
}
