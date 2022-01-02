package p0500_;

// Additive number is a string whose digits can form additive sequence.
//
// A valid additive sequence should contain at least three numbers. Except for the first two numbers,
// each subsequent number in the sequence must be the sum of the preceding two.
//
// For example:
// "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
// 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//
// "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
// 1 + 99 = 100, 99 + 100 = 199
//
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
//
// Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
//
// Follow up:
// How would you handle overflow for very large input integers?

/**
 * https://leetcode.com/problems/additive-number/
 */
public class Puzzle306_AdditiveNumber {

    public static void main(String[] args) {
        Puzzle306_AdditiveNumber.Solution s = new Puzzle306_AdditiveNumber().new Solution();
        System.out.println(s.isAdditiveNumber("123"));
    }

    public class Solution {
        public boolean isAdditiveNumber(String str) {
            int len = str.length();
            if (str == null || len < 3) {
                return false;
            }

            int head = len / 3 * 2;

            for (int i = 1; i < head; i++) {
                while (i < head && str.charAt(i) == '0' && str.charAt(i + 1) == '0') {
                    i++;
                }

                for (int j = i; j < head; j++) {
                    while (j < head && str.charAt(j) == '0' && str.charAt(j + 1) == '0') {
                        j++;
                    }
                    long a = Long.parseLong(str.substring(0, i));
                    long b = Long.parseLong(str.substring(i, j + 1));
                    if (check(a, b, str)) {
                        return true;
                    }
                }

            }

            return false;
        }

        private boolean check(long a, long b, String str) {
            String s = "" + a + b;
            long c;
            while (s.length() < str.length()) {
                c = a + b;
                a = b;
                b = c;
                s += c;
            }
            return s.equals(str);
        }
    }
}
