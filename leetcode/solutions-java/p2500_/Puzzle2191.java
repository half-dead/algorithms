package p2500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-the-jumbled-numbers/
 *
 * @author half-dead
 */
public class Puzzle2191 {
    class Solution {
        public int[] sortJumbled(int[] mapping, int[] nums) {
            int n = nums.length;
            int[][] temp = new int[n][2];
            for (int i = 0; i < n; i++) {
                int v = nums[i];
                int x = 0;
                for (char c : ("" + v).toCharArray()) {
                    int code = mapping[c - '0'];
                    x = x * 10 + code;
                }
                temp[i] = new int[]{i, x};
            }
            Arrays.sort(temp, (x, y) -> {
                int d = x[1] - y[1];
                return d != 0 ? d : x[0] - y[0];
            });

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nums[temp[i][0]];
            }
            return res;
        }
    }
}
