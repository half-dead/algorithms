package p2000_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
 *
 * @author half-dead
 */
public class Puzzle1807 {

    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>(knowledge.size());
            for (List<String> kv : knowledge) {
                map.put(kv.get(0), kv.get(1));
            }

            StringBuilder ans = new StringBuilder();
            String temp = "";
            boolean b = false;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    b = true;
                    temp = "";
                } else if (c == ')') {
                    b = false;
                    ans.append(map.getOrDefault(temp, "?"));
                } else {
                    if (b) temp += c;
                    else ans.append(c);
                }
            }
            return ans.toString();
        }
    }
}
