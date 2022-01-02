package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/cracking-the-safe/
 *
 * @author half-dead
 */
public class Puzzle753 {

    // De Bruijn sequence, O(K^N) space & time
    // https://en.wikipedia.org/wiki/De_Bruijn_sequence
    class Solution {
        public String crackSafe(int n, int k) {
            // there are k^n permutations
            // so there are k^(n-1) different prefixes, within the range [0, k^(n-1)-1]
            int mod = 1;
            for (int i = 1; i < n; i++) mod *= k;

            // for every prefix, we start at k-1, which is the max
            int[] candidates = new int[mod];
            Arrays.fill(candidates, k - 1);

            char[] cs = new char[n - 1 + mod * k];
            // generate n-1 zeros
            Arrays.fill(cs, 0, n - 1, '0');
            for (int i = n - 1, x = 0; i < cs.length; i++) {
                // get prefix
                x %= mod;
                // append number
                cs[i] = (char) ('0' + candidates[x]);
                // left shift x by 1 bit, then plus the recently added number
                // then decrement the candidate of that prefix by 1
                x = x * k + candidates[x]--;
            }
            return new String(cs);
        }
    }
}
