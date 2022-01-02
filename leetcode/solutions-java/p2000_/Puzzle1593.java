package p2000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 *
 * @author half-dead
 */
public class Puzzle1593 {

    public static void main(String[] args) {
        Solution s = new Puzzle1593().new Solution();
        System.out.println(s.maxUniqueSplit("ababccc"));
        System.out.println(s.maxUniqueSplit("aba"));
        System.out.println(s.maxUniqueSplit("aa"));
    }

    class Solution {
        public int maxUniqueSplit(String s) {
            int[] res = new int[1];
            Set<String> dict = new HashSet<>();
            backtracking(s.toCharArray(), 0, s.length() - 1, dict, res);
            return res[0];
        }

        public void backtracking(char[] chars, int from, int to, Set<String> dict, int[] res) {
            if (from > to) {
                res[0] = Math.max(res[0], dict.size());
                return;
            }

            for (int pos = from; pos <= to; pos++) {
                if (to - pos + 1 + dict.size() < res[0]) {
                    break;
                }
                String sub = new String(chars, from, pos - from + 1);
                if (!dict.contains(sub)) {
                    dict.add(sub);
                    backtracking(chars, pos + 1, to, dict, res);
                    dict.remove(sub);
                }
            }
        }
    }
}
