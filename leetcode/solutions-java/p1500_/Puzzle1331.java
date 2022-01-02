package p1500_;

import java.util.Arrays;

/**
 * Rank Transform of an Array
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * @author half-dead
 */
public class Puzzle1331 {
    public static void main(String[] args) {
        Solution s = new Puzzle1331().new Solution();
        int[] ints = s.arrayRankTransform(new int[]{4, 1, 2, 3, 1, 2, 3, 4, 4, 1, 3, 2, 1, 1});
        System.out.println(Arrays.toString(ints));
    }

    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int[] copy = new int[arr.length];
            System.arraycopy(arr, 0, copy, 0, arr.length);
            Arrays.sort(copy);
            int left = 0, right = 1;
            while (right < arr.length) {
                while (right < arr.length && copy[right] == copy[left]) right++;
                if (right < arr.length) copy[++left] = copy[right];
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Arrays.binarySearch(copy, 0, left + 1, arr[i]) + 1;
            }
            return arr;
        }
    }
}
