package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/ambiguous-coordinates/
 *
 * @author half-dead
 */
public class Puzzle816 {
    public static void main(String[] args) {
        Solution s = new Puzzle816().new Solution();
        System.out.println(s.ambiguousCoordinates("(123)"));
        System.out.println(s.ambiguousCoordinates("(00011)"));
        System.out.println(s.ambiguousCoordinates("(0123)"));
        System.out.println(s.ambiguousCoordinates("(100)"));
    }

    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            s = s.substring(1, s.length() - 1);
            int len = s.length();
            char[] cs = s.toCharArray();

            List<String> result = new LinkedList<>();
            Map<String, List<String>> memo = new HashMap<>();
            for (int cut = 1; cut < len; cut++) {
                List<String> left = gen(cs, 0, cut, memo), right = gen(cs, cut, len, memo);
                if (left.size() > 0 && right.size() > 0) {
                    for (String x : left)
                        for (String y : right)
                            result.add("(" + x + ", " + y + ")");
                }
            }
            return result;
        }

        List<String> gen(char[] cs, int from, int to, Map<String, List<String>> memo) {
            String key = new String(cs, from, to - from);
            List<String> res = memo.get(key);
            if (res != null) return res;

            int len = key.length();
            res = new ArrayList<>();
            if (len == 1 || cs[from] != '0') res.add(key);
            if (len > 1 && cs[to - 1] != '0') {
                if (cs[from] == '0') res.add("0." + key.substring(1));
                else for (int dot = 1; dot < len; dot++) res.add(key.substring(0, dot) + "." + key.substring(dot));
            }
            memo.put(key, res);
            return res;
        }
    }
}
