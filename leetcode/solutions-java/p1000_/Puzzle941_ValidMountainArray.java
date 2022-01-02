package p1000_;

/**
 * https://leetcode.com/problems/valid-mountain-array/
 *
 * @author half-dead
 */
public class Puzzle941_ValidMountainArray {

    class Solution {
        public boolean validMountainArray(int[] arr) {
            if (arr.length < 3) {
                return false;
            }
            int i = 0;
            while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                i++;
            }
            int j = arr.length - 1;
            while (j > 0 && arr[j] < arr[j - 1]) {
                j--;
            }
            if (i == 0 || j == arr.length - 1) {
                return false;
            }
            return i == j;

        }
    }
}
