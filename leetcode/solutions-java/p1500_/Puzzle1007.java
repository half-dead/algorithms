package p1500_;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 *
 * @author half-dead
 */
public class Puzzle1007 {

    class Solution {
        public int minDominoRotations(int[] a, int[] b) {
            int len = a.length, max = 0;
            int[] cnt = new int[7];
            for (int n : a) max = Math.max(max, ++cnt[n]);
            for (int n : b) max = Math.max(max, ++cnt[n]);
            if (max < len) return -1;

            int target = 1;
            for (int i = 2; i < 7; i++)
                if (cnt[i] == max) {
                    target = i;
                    break;
                }

            int top = 0, bottom = 0;
            for (int i = 0; i < len; i++) {
                if (a[i] != target && b[i] != target) return -1;
                if (a[i] == target) top++;
                if (b[i] == target) bottom++;
            }
            return Math.min(len - top, len - bottom);
        }
    }
}
