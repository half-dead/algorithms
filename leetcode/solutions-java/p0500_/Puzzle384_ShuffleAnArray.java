package p0500_;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 *
 * @author half-dead
 */
public class Puzzle384_ShuffleAnArray {

    public static void main(String[] args) {
        Puzzle384_ShuffleAnArray p = new Puzzle384_ShuffleAnArray();
        Solution s = p.new Solution(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
        System.out.println(Arrays.toString(s.shuffle()));
    }

    class Solution {
        private int[] arr;
        private int[] shuffled;
        private Random rand;

        public Solution(int[] nums) {
            this.rand = new Random();
            this.arr = nums;
            this.shuffled = new int[nums.length];
        }

        public int[] reset() {
            return arr;
        }

        public int[] shuffle() {
            System.arraycopy(arr, 0, shuffled, 0, arr.length);
            for (int j = 1; j < shuffled.length; j++) {
                int i = rand.nextInt(j + 1);
                swap(shuffled, i, j);
            }
            return shuffled;
        }

        public void swap(int[] arr, int i, int j) {
            if (i != j) {
                int n = arr[i];
                arr[i] = arr[j];
                arr[j] = n;
            }
        }
    }

}
