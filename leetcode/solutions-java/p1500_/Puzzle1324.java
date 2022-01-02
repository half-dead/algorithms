package p1500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/print-words-vertically/
 *
 * @author half-dead
 */
public class Puzzle1324 {
    public static void main(String[] args) {
        Solution s = new Puzzle1324().new Solution();
        System.out.println(s.printVertically("TO BE OR NOT TO BE"));
    }

    class Solution {
        public List<String> printVertically(String s) {
            String[] words = s.split(" ");
            int max = 0;
            for (String word : words) max = Math.max(max, word.length());
            char[][] chars = new char[max][words.length];
            for (char[] row : chars) Arrays.fill(row, ' ');

            for (int c = 0; c < words.length; c++)
                for (int r = 0; r < words[c].length(); r++)
                    chars[r][c] = words[c].charAt(r);
            List<String> result = new ArrayList<>(max);
            for (char[] row : chars) {
                int i = row.length - 1;
                while (row[i] == ' ') i--;
                result.add(new String(row, 0, i + 1));
            }
            return result;
        }
    }
}
