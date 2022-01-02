package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-time-for-given-digits/
 *
 * @author half-dead
 */
public class Puzzle949_LargestTimeForGivenDigits {
    public static void main(String[] args) {
        Puzzle949_LargestTimeForGivenDigits p = new Puzzle949_LargestTimeForGivenDigits();
        Solution solution = p.new Solution();
        String result = solution.largestTimeFromDigits(new int[]{1, 2, 3, 4});
        System.out.println(result);
    }

    class Solution {
        public String largestTimeFromDigits(int[] arr) {
            Arrays.sort(arr);
            if (arr[0] > 2 || arr[1] > 5) {
                return "";
            }

            reverse(arr, 0, arr.length - 1);
            do {
                if (validate(arr)) {
                    return "" + arr[0] + arr[1] + ":" + arr[2] + arr[3];
                }
            } while (hasLesserPermutation(arr));
            return "";
        }

        private boolean hasLesserPermutation(int[] arr) {
            int len = arr.length, i = 0;
            while (i < len - 1 && arr[i] <= arr[i + 1]) {
                i++;
            }
            if (i == len - 1) {
                return false;
            }

            i = len - 1;
            while (i > 0 && arr[i] >= arr[i - 1]) {
                i--;
            }

            int comp = arr[i - 1], max = arr[i], maxIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < comp && arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            swap(arr, i - 1, maxIndex);
            Arrays.sort(arr, i, len);
            reverse(arr, i, len - 1);
            return true;
        }

        private boolean validate(int[] arr) {
            int hour = arr[0] * 10 + arr[1];
            int minute = arr[2] * 10 + arr[3];
            return hour < 24 && minute < 60;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private void reverse(int[] arr, int from, int to) {
            while (from < to) {
                swap(arr, from, to);
                from++;
                to--;
            }
        }
    }
}
