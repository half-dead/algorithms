package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 *
 * @author half-dead
 */
public class Puzzle1636 {

    class Solution {
        public int[] frequencySort(int[] nums) {
            int[][] freq = new int[201][2];
            for (int n : nums) freq[n + 100][0]++;
            for (int i = 0; i < 201; i++) freq[i][1] = i - 100;
            Arrays.sort(freq, (a, b) -> {
                int d = a[0] - b[0];
                return d != 0 ? d : b[1] - a[1];
            });
            int i = 0, j = 0;
            while (i < nums.length) {
                while (freq[j][0] == 0) j++;
                nums[i++] = freq[j][1];
                freq[j][0]--;
            }
            return nums;
        }
    }
}
