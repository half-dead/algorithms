package p0500_;

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
// (you may want to display this pattern in a fixed font for better legibility)
//
// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
//
// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

/**
 * https://oj.leetcode.com/problems/zigzag-conversion/
 */
public class Puzzle006_ZigZagConversion {

    public static void main(String[] args) {
        Puzzle006_ZigZagConversion p = new Puzzle006_ZigZagConversion();

        Solution1 solution1 = p.new Solution1();
        String convert = solution1.convert("PAYPALISHIRING", 4);
        System.out.println(convert);

        Solution2 solution2 = p.new Solution2();
        convert = solution2.convert("PAYPALISHIRING", 4);
        System.out.println(convert);
    }

    public class Solution1 {
        public String convert(String s, int nRows) {
            if (nRows == 1)
                return s;
            char[][] temp = new char[nRows][s.length() / 2];
            char[] chars = s.toCharArray();
            int i = 0, j = 0;
            boolean forward = true;
            for (int k = 0; k < s.length(); k++) {
                temp[j][i] = chars[k];
                if (forward) {
                    if (++j == nRows - 1) {
                        forward = false;
                    }
                } else {
                    ++i;
                    if (--j == 0) {
                        forward = true;
                    }
                }
            }

            int m = 0;
            char[] result = new char[s.length()];
            for (char[] chars1 : temp) {
                for (char c : chars1) {
                    System.out.print(c == 0 ? ' ' : c);
                    if (c != 0)
                        result[m++] = c;
                }
                System.out.println();
            }
            return String.valueOf(result);
        }
    }

    public class Solution2 {
        public String convert(String s, int nRows) {
            if (nRows <= 1)
                return s;

            int k = 0;
            int len = s.length();
            int period = 2 * nRows - 2;
            char[] result = new char[len];
            for (int i = 0; i < nRows; i++) {
                int j = i, inc = period - 2 * i;
                while (j < len) {
                    result[k++] = s.charAt(j);
                    j += (i > 0 && i < nRows - 1) ? inc : period;
                    inc = period - inc;
                }
            }
            return new String(result);
        }
    }
}
