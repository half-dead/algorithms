package p1000_;

/**
 * https://leetcode.com/problems/mirror-reflection/
 *
 * @author half-dead
 */
public class Puzzle858 {

    public static void main(String[] args) {
        System.out.println(-4 % 3);
    }

    class Solution {
        public int mirrorReflection(int p, int q) {
            int nq = q;
            while (nq % p != 0) nq += q;
            int x = nq / q, y = nq / p;
            return x % 2 == 0 ? 2 : (y % 2 == 0 ? 0 : 1);
        }
    }
}
