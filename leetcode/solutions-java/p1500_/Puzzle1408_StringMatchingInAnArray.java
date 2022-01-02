package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/
 *
 * @author half-dead
 */
public class Puzzle1408_StringMatchingInAnArray {

    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> result = new ArrayList<>();
            for (String w1 : words) {
                for (String w2 : words) {
                    if (!w1.equals(w2) && w2.contains(w1)) {
                        result.add(w1);
                        break;
                    }
                }
            }
            return result;
        }
    }
}
