package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/can-make-palindrome-from-substring/
 *
 * @author half-dead
 */
public class Puzzle1177 {

    class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int[] xors = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                int bit = 1 << (s.charAt(i) - 'a');
                xors[i] = i == 0 ? bit : (xors[i - 1] ^ bit);
            }

            List<Boolean> res = new ArrayList<>(queries.length);
            for (int[] q : queries) {
                int left = q[0], right = q[1], k = q[2];
                int c = xors[right] ^ (left == 0 ? 0 : xors[left - 1]);
                res.add(Integer.bitCount(c) - k * 2 <= 1);
            }
            return res;
        }
    }
}
