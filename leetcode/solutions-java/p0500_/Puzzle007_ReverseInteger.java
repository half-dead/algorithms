package p0500_;

// Reverse digits of an integer.
//
// Example1: x = 123, return 321
// Example2: x = -123, return -321
//
// click to show spoilers.
//
// Have you thought about this?
// Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
//
// If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
//
// Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
//
// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//
// Update (2014-11-10):
// Test cases had been added to test the overflow behavior.

/**
 * https://oj.leetcode.com/problems/reverse-integer/
 */
public class Puzzle007_ReverseInteger {

    public static void main(String[] args) {
        Puzzle007_ReverseInteger puzzle007 = new Puzzle007_ReverseInteger();
        Solution s = puzzle007.new Solution();
        System.out.println(s.reverse(2147483647));

        VeryStupidSolution s1 = puzzle007.new VeryStupidSolution();
        System.out.println(s1.reverse(2147483647));
    }

    public class Solution {
        public int reverse(int x) {
            if (x == 0)
                return 0;
            long result = 0;
            while (x != 0) {
                result = 10 * result + (x % 10);
                if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
                    return 0;
                x /= 10;
            }
            return (int) result;
        }
    }

    public class VeryStupidSolution {
        public int reverse(int x) {
            StringBuilder sb = new StringBuilder().append(x);
            sb.reverse();
            if (sb.charAt(sb.length() - 1) == '-') {
                sb.deleteCharAt(sb.length() - 1).insert(0, '-');
            }
            int result = 0;
            try {
                result = Integer.parseInt(sb.toString());
            } catch (NumberFormatException e) {
            }
            return result;
        }
    }
}
