package p1000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/walking-robot-simulation/
 *
 * @author half-dead
 */
public class Puzzle874 {

    public static void main(String[] args) {

        short i = -1;
        int j = 0 | i;
        System.out.println(j);
        Solution s = new Puzzle874().new Solution();
        System.out.println(s.robotSim(new int[]{2, -1, 8, -1, 6}, new int[][]{
                {1, 5}, {-5, -5}, {0, 4}, {-1, -1}, {4, 5}, {-5, -3}, {-2, 1}, {-2, -5}, {0, 5}, {0, -1}
        }));
    }

    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int COMP = 32768;
            Set<Integer> set = new HashSet<>(obstacles.length);
            for (int[] ob : obstacles) set.add(ob[0] + COMP << 16 | ob[1] + COMP);

            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int x = 0, y = 0, d = 0, max = 0;
            for (int cmd : commands) {
                if (cmd == -2) d = (d + 3) % 4;
                else if (cmd == -1) d = (d + 1) % 4;
                else {
                    while (cmd-- > 0) {
                        int nextx = x + directions[d][0], nexty = y + directions[d][1];
                        if (set.contains(nextx + COMP << 16 | nexty + COMP)) break;
                        max = Math.max(max, (x = nextx) * x + (y = nexty) * y);
                    }
                }
            }
            return max;
        }
    }
}
