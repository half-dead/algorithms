package p2000_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/
 *
 * @author half-dead
 */
public class Puzzle1981 {

    class Solution {
        public int minimizeTheDifference(int[][] mat, int target) {
            int m = mat.length, n = mat[0].length, minsum = 0, maxsum = 0;
            for (int[] row : mat) {
                Arrays.sort(row);
                minsum += row[0];
                maxsum += row[n - 1];
            }
            if (minsum >= target) return minsum - target;
            if (maxsum <= target) return target - maxsum;

            int res = Math.min(maxsum - target, target - minsum), limit = Math.min(target * 2, maxsum);
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for (int[] row : mat) {
                Set<Integer> next = new HashSet<>();
                for (int prev : set) {
                    for (int element : row) {
                        int curr = prev + element;
                        if (curr <= limit) {
                            next.add(curr);
                        }
                    }
                }
                set = next;
            }
            for (int x : set) res = Math.min(res, Math.abs(x - target));
            return res;
        }

    }
}
