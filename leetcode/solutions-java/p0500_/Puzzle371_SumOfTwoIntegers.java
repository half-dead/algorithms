package p0500_;

// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//
// Example:
// Given a = 1 and b = 2, return 3.


/**
 * https://leetcode.com/problems/sum-of-two-integers/
 */
public class Puzzle371_SumOfTwoIntegers {

    public static void main(String[] args) {
        Puzzle371_SumOfTwoIntegers p = new Puzzle371_SumOfTwoIntegers();
        Solution solution = p.new Solution();
        System.out.println(solution.getSum(1, 2));

        Solution2 s2 = p.new Solution2();
        System.out.println(s2.getSum(-12, -8));
    }

    public class Solution {
        public int getSum(int a, int b) {
            String as = Integer.toBinaryString(a), bs = Integer.toBinaryString(b);
            int i = 0, maxLen = Math.max(as.length(), bs.length()), j = 32;
            boolean extra = false, temp;
            char[] sum = new char[32];
            for (int k = 0; k < 32; k++) {
                sum[k] = '0';
            }
            while (i++ < maxLen) {
                boolean ba = getBit(as, i), bb = getBit(bs, i);
                temp = ba ^ bb;
                sum[--j] = (temp ^ extra) ? '1' : '0';
                extra = (ba & bb) | (temp & extra);
            }
            if (j > 0) {
                sum[--j] = extra ? '1' : '0';
            }
            return Integer.parseUnsignedInt(new String(sum), 2);
        }

        private boolean getBit(String s, int i) {
            if (i > s.length()) {
                return false;
            }
            return s.charAt(s.length() - i) == '1';
        }

    }

    public class Solution2 {
        public int getSum(int a, int b) {
            if (b == 0) {
                return a;
            }
            int sum, carry;
            sum = a ^ b;
            carry = (a & b) << 1;
            return getSum(sum, carry);
        }
    }

}
