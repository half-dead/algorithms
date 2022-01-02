package p1000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/positions-of-large-groups/
 *
 * @author half-dead
 */
public class Puzzle830 {
    class Solution {
        public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> res = new ArrayList<>();
            char[] chars = s.toCharArray();
            for (int from = 0, to = 0; from < chars.length; from = to) {
                while (to < chars.length && chars[to] == chars[from]) to++;
                if (to - from > 2) res.add(Arrays.asList(from, to - 1));
            }
            return res;
        }
    }
}
