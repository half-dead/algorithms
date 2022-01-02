package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1536 {

    class Solution {
        public int minSwaps(int[][] grid) {
            int len = grid.length, res = 0;

            int[] rightMostOneIndex = new int[len], numOfOneInColumn = new int[len];
            for (int r = 0; r < len; r++) {
                for (int c = 0; c < len; c++) {
                    numOfOneInColumn[c] += grid[r][c];
                    rightMostOneIndex[r] = Math.max(rightMostOneIndex[r], grid[r][c] == 1 ? c : 0);
                }
            }

            for (int i = 0, maxAllowedCount = len; i < len; i++, maxAllowedCount--)
                if (numOfOneInColumn[i] > maxAllowedCount) return -1;

            for (int i = 0; i < len; i++) {
                if (rightMostOneIndex[i] <= i) continue;

                int j = i + 1;
                while (j < len) {
                    if (rightMostOneIndex[j] <= i) break;
                    j++;
                }
                if (j == len) return -1;

                res += j - i;
                int temp = rightMostOneIndex[j];
                while (j > i) {
                    rightMostOneIndex[j] = rightMostOneIndex[j - 1];
                    j--;
                }
                rightMostOneIndex[i] = temp;
            }
            return res;
        }
    }
}
