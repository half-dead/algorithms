package p1500_;

/**
 * https://leetcode.com/problems/smallest-integer-divisible-by-k/
 *
 * @author half-dead
 */
public class Puzzle1015 {

    class Solution {
        public int smallestRepunitDivByK(int k) {
            if (k % 2 == 0 || k % 5 == 0) return -1;

            boolean[] seen = new boolean[k];
            int x = 0, res = 0;
            while (true) {
                x = (x * 10 + 1) % k;
                res++;
                if (x == 0) return res;
                if (seen[x]) break;
                seen[x] = true;
            }
            return -1;
        }
    }
}
