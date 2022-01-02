package p1500_;

/**
 * https://leetcode.com/problems/jump-game-iii/
 *
 * @author half-dead
 */
public class Puzzle1306_JumpGameIII {
    class Solution {
        public boolean canReach(int[] arr, int start) {
            if (arr[start] == 0) return true;

            int left = start - arr[start];
            int right = start + arr[start];
            arr[start] = -1;

            boolean b = false;
            if (left >= 0 && arr[left] >= 0) {
                b = b | canReach(arr, left);
            }
            if (right < arr.length && arr[right] >= 0) {
                b = b | canReach(arr, right);
            }
            return b;
        }
    }
}
