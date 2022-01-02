package p2000_;

/**
 * https://leetcode.com/problems/find-the-winner-of-an-array-game/
 *
 * @author half-dead
 */
public class Puzzle1535 {

    class Solution {
        public int getWinner(int[] arr, int k) {
            int len = arr.length, win = 0, i = 1, max = arr[0];
            k = Math.min(k, len - 1);
            while (i < len && win < k) {
                if (arr[i] > max) {
                    max = arr[i];
                    win = 1;
                } else {
                    win++;
                }
                i++;
            }
            return max;
        }
    }
}
