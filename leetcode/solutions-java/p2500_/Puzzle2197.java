package p2500_;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/replace-non-coprime-numbers-in-array/
 *
 * @author half-dead
 */
public class Puzzle2197 {

    // stack
    class Solution {
        public List<Integer> replaceNonCoprimes(int[] nums) {
            int gcd;
            LinkedList<Integer> dq = new LinkedList<>();
            for (int v : nums) {
                while (dq.size() > 0 && (gcd = gcd(v, dq.peekLast())) != 1) {
                    v = v / gcd * dq.pollLast();
                }
                dq.addLast(v);
            }
            return dq;
        }

        int gcd(int x, int y) {
            if (y == 0) return x;
            return gcd(y, x % y);
        }
    }
}
