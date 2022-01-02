package p1500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/alphabet-board-path/
 *
 * @author half-dead
 */
public class Puzzle1138 {

    class Solution {
        public String alphabetBoardPath(String target) {
            Map<Character, int[]> map = new HashMap<>(26);
            for (int c = 'a', idx = 0; idx < 26; idx++, c++) map.put((char) c, new int[]{idx / 5, idx % 5});

            int row = 0, col = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : target.toCharArray()) {
                int[] pair = map.get(c);
                if (row == 5 && pair[0] != 5) {
                    sb.append('U');
                    row--;
                }
                if (col != pair[1]) {
                    int diff = Math.abs(col - pair[1]);
                    while (diff-- > 0) sb.append(pair[1] > col ? 'R' : 'L');
                }
                if (row != pair[0]) {
                    int diff = Math.abs(row - pair[0]);
                    while (diff-- > 0) sb.append(pair[0] > row ? 'D' : 'U');
                }
                sb.append('!');
                row = pair[0];
                col = pair[1];
            }
            return sb.toString();
        }
    }
}
