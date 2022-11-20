package p2500_;

/**
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
 */
public class Puzzle2433 {
    class Solution {
        public int[] findArray(int[] pref) {
            int n = pref.length;
            int[] res = new int[n];
            for (int i = 0, xor = 0; i < n; i++) {
                res[i] = xor ^ pref[i];
                xor ^= res[i];
            }
            return res;
        }
    }
}
