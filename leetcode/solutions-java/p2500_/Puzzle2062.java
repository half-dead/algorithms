package p2500_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-vowel-substrings-of-a-string/
 *
 * @author half-dead
 */
public class Puzzle2062 {

    // sliding-window
    class Solution {
        public int countVowelSubstrings(String word) {
            char[] dict = new char[]{'a', 'e', 'i', 'o', 'u'};
            Set<Character> aeiou = new HashSet<>(5);
            for (char c : dict) aeiou.add(c);

            int[] freq = new int[128];
            char[] cs = word.toCharArray();

            // lo: start index of a all-vowel substring
            // hi: start index of a shortest substring that contains all 5 vowels
            int n = word.length(), lo = 0, hi = 0, cnt = 0, res = 0;
            for (int i = 0; i < n; i++) {
                char c = cs[i];
                if (aeiou.contains(c)) {
                    if (freq[c]++ == 0) cnt++;

                    while (cnt == 5) {
                        char pop = word.charAt(hi);
                        if (--freq[pop] == 0) cnt--;
                        hi++;
                    }
                    res += hi - lo;

                } else {
                    for (char vowel : aeiou) freq[vowel] = 0;
                    cnt = 0;
                    lo = hi = i + 1;
                }
            }
            return res;
        }
    }
}
