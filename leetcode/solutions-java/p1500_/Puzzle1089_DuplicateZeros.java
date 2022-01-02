package p1500_;

/**
 * https://leetcode.com/problems/duplicate-zeros/
 *
 * @author half-dead
 */
public class Puzzle1089_DuplicateZeros {
    class Solution {
        public void duplicateZeros(int[] arr) {
            int len = arr.length, i = 0, j = len - 1, zeros = 0;
            for (; i + zeros < len; i++) if (arr[i] == 0) zeros++;
            if (zeros == 0) return;

            while (--i >= 0) {
                if (arr[i] == 0) {
                    if (i + zeros < len) arr[j--] = 0;
                    arr[j--] = 0;
                } else arr[j--] = arr[i];
            }
        }
    }
}
