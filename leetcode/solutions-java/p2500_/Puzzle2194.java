package p2500_;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
 *
 * @author half-dead
 */
public class Puzzle2194 {

    class Solution {
        public List<String> cellsInRange(String s) {
            List<String> list = new LinkedList<>();
            char cs = s.charAt(0), ce = s.charAt(3);
            int rs = s.charAt(1) - '0', re = s.charAt(4) - '0';
            for (int i = cs; i <= ce; i++) {
                for (int j = rs; j <= re; j++) {
                    list.add("" + (char) i + j);
                }
            }
            return list;
        }
    }
}
