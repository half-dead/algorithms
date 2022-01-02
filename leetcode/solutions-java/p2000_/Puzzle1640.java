package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/check-array-formation-through-concatenation/
 *
 * @author half-dead
 */
public class Puzzle1640 {

    public static void main(String[] args) {
        Solution s = new Puzzle1640().new Solution();
        System.out.println(s.canFormArray(new int[]{49, 18, 16}, new int[][]{}));
    }

    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            int[] map = new int[101];
            Arrays.fill(map, -1);
            for (int i = 0; i < arr.length; i++) map[arr[i]] = i;

            for (int[] p : pieces) {
                for (int i = 0, start = map[p[0]]; i < p.length; i++, start++) {
                    if (start < 0 || start >= arr.length || arr[start] != p[i]) return false;
                }
            }
            return true;
        }
    }
}
