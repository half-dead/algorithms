package p1500_;

/**
 * https://leetcode.com/problems/xor-queries-of-a-subarray/
 *
 * @author half-dead
 */
public class Puzzle1310 {

    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int n = queries.length, idx = 0;
            int[] res = new int[n];
            for (int i = 1; i < arr.length; i++) arr[i] ^= arr[i - 1];

            for (int[] q : queries) res[idx++] = arr[q[1]] ^ (q[0] == 0 ? 0 : arr[q[0] - 1]);
            return res;
        }
    }
}
