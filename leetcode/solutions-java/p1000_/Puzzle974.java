package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 *
 * @author half-dead
 */
public class Puzzle974 {

    class Solution {
        public int subarraysDivByK(int[] a, int k) {
            int[] count = new int[k];
            count[0] = 1;
            int sum = 0, res = 0;
            for (int n : a) {
                sum = (sum + n % k + k) % k;
                res += count[sum]++;
            }
            return res;
        }
    }
}
