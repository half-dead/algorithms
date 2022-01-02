package p2000_;

import java.util.List;

/**
 * https://leetcode.com/problems/count-items-matching-a-rule/
 *
 * @author half-dead
 */
public class Puzzle1773 {

    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int res = 0, i = 0;
            if (ruleKey.equals("color")) i = 1;
            else if (ruleKey.equals("name")) i = 2;
            for (List<String> item : items) {
                if (item.get(i).equals(ruleValue)) res++;
            }
            return res;
        }
    }
}
