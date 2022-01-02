package p0500_;

// Given an integer, convert it to a roman numeral.
// Input is guaranteed to be within the range from 1 to 3999.

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class Puzzle012_IntegerToRoman {

    public static void main(String[] args) {
        Puzzle012_IntegerToRoman p = new Puzzle012_IntegerToRoman();
        Solution solution = p.new Solution();
        String s = solution.intToRoman(3999);
        System.out.println(s);
    }

    public class Solution {
        public String intToRoman(int num) {
            StringBuilder builder = new StringBuilder();
            String[] units = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] factors = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            int factorIndex = 0;
            while (num > 0) {
                while (num < factors[factorIndex]) {
                    factorIndex++;
                }
                builder.append(units[factorIndex]);
                num -= factors[factorIndex];
            }
            return builder.toString();
        }
    }
}
