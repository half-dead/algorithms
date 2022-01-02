package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-missing-observations/
 *
 * @author half-dead
 */
public class Puzzle2028 {

    // greedy, straight forward
    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int m = rolls.length, total = (m + n) * mean;

            for (int v : rolls) total -= v;
            if (total < n || total > n * 6) return new int[0];

            int[] res = new int[n];

            int avg = total / n, mod = total % n;
            Arrays.fill(res, avg);

            for (int i = 0; i < mod; i++) res[i]++;
            return res;
        }
    }

}
