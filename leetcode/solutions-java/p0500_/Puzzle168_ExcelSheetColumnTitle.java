package p0500_;

// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//    For example:
//
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB

/**
 * https://oj.leetcode.com/problems/excel-sheet-column-title/
 */
public class Puzzle168_ExcelSheetColumnTitle {

    public class Solution {
        public String convertToTitle(int n) {
            StringBuilder builder = new StringBuilder();
            int mod;
            while (n != 0) {
                mod = n % 26;
                builder.append(mod == 0 ? 'Z' : (char) ('A' + mod - 1));
                n = mod == 0 ? (n - 26) / 26 : n / 26;
            }
            return builder.reverse().toString();
        }
    }
}
