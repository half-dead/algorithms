package p1500_;

/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 *
 * @author half-dead
 */
public class Puzzle1012_ComplementOfBase10Integer {
    public static void main(String[] args) {
        Puzzle1012_ComplementOfBase10Integer p = new Puzzle1012_ComplementOfBase10Integer();
        Solution s = p.new Solution();
        System.out.println(s.bitwiseComplement(5));
        System.out.println(s.bitwiseComplement(7));
        System.out.println(s.bitwiseComplement(10));
        System.out.println(s.bitwiseComplement(0));
    }

    class Solution {
        public int bitwiseComplement(int n) {
            int res = 0, d = 0;
            do {
                res |= ((1 - (n & 1)) << d++);
                n >>>= 1;
            } while (n > 0);
            return res;
        }
    }
}
