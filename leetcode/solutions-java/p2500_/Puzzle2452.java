package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/words-within-two-edits-of-dictionary/
 */
public class Puzzle2452 {
    class Solution {
        public List<String> twoEditWords(String[] queries, String[] dict) {
            List<String> ans = new ArrayList<>();
            for (String q : queries) {
                for (String word : dict) {
                    int cnt = 0;
                    for (int i = 0; i < word.length(); i++) {
                        if (q.charAt(i) != word.charAt(i) && ++cnt > 2) break;
                    }
                    if (cnt <= 2) {
                        ans.add(q);
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
