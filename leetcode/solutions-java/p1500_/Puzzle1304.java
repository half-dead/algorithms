package p1500_;

/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 *
 * @author half-dead
 */
public class Puzzle1304 {
    class Solution {
        public int[] sumZero(int n) {
            int[] result = new int[n];
            if ((n & 1) != 0) result[--n] = 0;

            int i = -1, m = 0;
            while (++i < n)
                if ((i & 1) == 0) result[i] = ++m;
                else result[i] = -m;
            return result;
        }
    }
}
