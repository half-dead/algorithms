package p0500_;

// Given a digit string, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below.
//
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Puzzle017_LetterCombinationsOfAPhoneNumber {
    public class Solution {
        final String all = "23456789";
        final char[][] chars = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };

        public List<String> letterCombinations(String digits) {
            char[] arr = digits.toCharArray();
            List<StringBuilder> builders = new ArrayList<>();
            boolean cap = false;
            for (char c : arr) {
                if (c == '#') {
                    cap = !cap;
                } else if (c == '*' || c == '0') {
                    if (builders.size() == 0) {
                        StringBuilder builder = new StringBuilder(arr.length);
                        builders.add(builder);
                    }
                    for (StringBuilder builder : builders) {
                        builder.append(c == '*' ? '+' : ' ');
                    }
                } else if (c > '1' && c <= '9') {
                    if (builders.size() == 0) {
                        for (char cc : chars[all.indexOf(c)]) {
                            StringBuilder builder = new StringBuilder(arr.length);
                            builder.append(cc);
                            builders.add(builder);
                        }
                    } else {
                        int size = builders.size();
                        for (int i = 0; i < size; i++) {
                            char[] group = chars[all.indexOf(c)];
                            for (int j = 0; j < group.length; j++) {
                                if (j == 0) {
                                    builders.get(i).append(cap ? (char) (group[j] - 32) : group[j]);
                                } else {
                                    StringBuilder sb = new StringBuilder(arr.length);
                                    sb.append(builders.get(i), 0, builders.get(i).length() - 1).append(cap ? (char) (group[j] - 32) : group[j]);
                                    builders.add(sb);
                                }
                            }
                        }
                    }
                }
            }
            List<String> list = new ArrayList<>(builders.size());
            for (StringBuilder builder : builders) {
                list.add(builder.toString());
            }
            return list;
        }
    }
}
