package p0500_;

/**
 * https://leetcode.com/problems/super-pow/
 *
 * @author half-dead
 */
public class Puzzle372 {
    public static void main(String[] args) {
        Solution s = new Puzzle372().new Solution();
        System.out.println(s.superPow(2, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    class Solution {
        public int superPow(int a, int[] b) {
            int mod = 1337, res = 1, prev = (a %= mod);
            for (int i = 0; i < b.length; i++) {
                if (i > 0)
                    for (int m = 0; m < 9; m++) res = (res * prev) % mod;

                while (b[i]-- > 0) res = (res * a) % mod;
                prev = res;
            }
            return res % mod;
        }
    }
}
