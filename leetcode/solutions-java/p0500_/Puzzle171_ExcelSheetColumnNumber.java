package p0500_;

// Related to question Excel Sheet Column Title
//
// Given a column title as appear in an Excel sheet, return its corresponding column number.
//
// For example:
//
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28

/**
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 */
public class Puzzle171_ExcelSheetColumnNumber {

    public class Solution {
        public int titleToNumber(String s) {
            int result = 0;
            int tail = s.length() - 1;
            for (int i = tail; i > -1; i--) {
                result = result * 26 + (s.charAt(tail - i) - 'A' + 1);
            }
            return result;
        }
    }

    public class Solution2 {
        public int titleToNumber(String s) {
            int result = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                result += (s.charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1);
            }
            return result;
        }
    }
}
