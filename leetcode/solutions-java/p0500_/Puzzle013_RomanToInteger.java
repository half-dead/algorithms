package p0500_;

// Given a roman numeral, convert it to an integer.
// Input is guaranteed to be within the range from 1 to 3999.

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class Puzzle013_RomanToInteger {
    public static void main(String[] args) {
        Puzzle013_RomanToInteger p = new Puzzle013_RomanToInteger();
        Solution solution = p.new Solution();
        int i = solution.romanToInt("MCMXCVI");
        System.out.println(i);
    }

    public class Solution {
        public int romanToInt(String s) {
            char[] chars = s.toCharArray();
            int result = 0;
            char prev = '\0';
            for (char c : chars) {
                switch (c) {
                    case 'I':
                        result += 1;
                        break;
                    case 'V':
                        result += prev == 'I' ? 3 : 5;
                        break;
                    case 'X':
                        result += prev == 'I' ? 8 : 10;
                        break;
                    case 'L':
                        result += prev == 'X' ? 30 : 50;
                        break;
                    case 'C':
                        result += prev == 'X' ? 80 : 100;
                        break;
                    case 'D':
                        result += prev == 'C' ? 300 : 500;
                        break;
                    case 'M':
                        result += prev == 'C' ? 800 : 1000;
                        break;
                }
                prev = c;
            }
            return result;
        }
    }
}
