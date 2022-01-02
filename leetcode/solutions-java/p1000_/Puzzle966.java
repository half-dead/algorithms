package p1000_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/vowel-spellchecker/
 *
 * @author half-dead
 */
public class Puzzle966 {

    class Solution {
        public String[] spellchecker(String[] wordlist, String[] queries) {
            Set<String> set = new HashSet<>();
            Map<String, String> map1 = new HashMap<>(), map2 = new HashMap<>();
            for (String word : wordlist) {
                set.add(word);
                String lower = word.toLowerCase(), nonVowel = devowel(lower);
                map1.putIfAbsent(lower, word);
                map2.putIfAbsent(nonVowel, word);
            }

            int n = queries.length;
            String[] ans = new String[n];
            for (int i = 0; i < n; i++) {
                String query = queries[i];
                if (set.contains(query)) {
                    ans[i] = query;
                    continue;
                }
                String lower = query.toLowerCase(), match = map1.get(lower);
                if (match != null) {
                    ans[i] = match;
                    continue;
                }
                match = map2.get(devowel(lower));
                ans[i] = match == null ? "" : match;
            }
            return ans;
        }

        String devowel(String s) {
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == 'a' || cs[i] == 'e' || cs[i] == 'i' || cs[i] == 'o' || cs[i] == 'u') cs[i] = ' ';
            }
            return new String(cs);
        }
    }
}
