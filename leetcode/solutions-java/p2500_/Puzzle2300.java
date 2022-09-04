package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 *
 * @author half-dead
 */
public class Puzzle2300 {

    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int n = spells.length, m = potions.length;
            int[] res = new int[n];

            int[][] temp = new int[n][2];
            for (int i = 0; i < n; i++) {
                temp[i] = new int[]{spells[i], i};
            }
            Arrays.sort(temp, (a, b) -> a[0] - b[0]);

            Arrays.sort(potions);

            int i = 0, j = m - 1;
            while (i < n) {
                while (j >= 0 && temp[i][0] * (long) potions[j] >= success) {
                    j--;
                }
                res[temp[i][1]] = m - j - 1;
                i++;
            }
            return res;
        }
    }
}
