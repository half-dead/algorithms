package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * @author half-dead
 */
public class Puzzle977_SquaresOfASortedArray {
    public static void main(String[] args) {
        Puzzle977_SquaresOfASortedArray p = new Puzzle977_SquaresOfASortedArray();
        Solution s = p.new Solution();
        int[] ints = s.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
    }

    class Solution {
        public int[] sortedSquares(int[] arr) {
            int len = arr.length;
            int[] result = new int[len];
            int negIdx = -1;
            for (int i = 0; i < len; i++) {
                if (arr[i] < 0) {
                    negIdx++;
                }
                arr[i] = arr[i] * arr[i];
            }
            int posIdx = negIdx + 1;
            for (int i = 0; i < len; i++) {
                if (negIdx >= 0 && negIdx < len && posIdx >= 0 && posIdx < len) {
                    if (arr[negIdx] < arr[posIdx]) {
                        result[i] = arr[negIdx];
                        negIdx--;
                    } else {
                        result[i] = arr[posIdx];
                        posIdx++;
                    }
                } else if (negIdx >= 0 && negIdx < len) {
                    result[i] = arr[negIdx];
                    negIdx--;
                } else {
                    result[i] = arr[posIdx];
                    posIdx++;
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int[] sortedSquares(int[] arr) {
            int head = 0, tail = arr.length - 1;
            int[] res = new int[arr.length];
            int index = arr.length - 1;

            while (index >= 0) {
                if (Math.abs(arr[head]) > Math.abs(arr[tail])) {
                    res[index--] = arr[head] * arr[head];
                    head++;
                } else {
                    res[index--] = arr[tail] * arr[tail];
                    tail--;
                }
            }
            return res;
        }
    }
}
