package p1500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
 *
 * @author half-dead
 */
public class Puzzle1297 {

    // parameter 'max' is useless!
    class Solution {
        public int maxFreq(String s, int letters, int min, int max) {
            int[] cnt = new int[128];
            char[] cs = s.toCharArray();
            Map<String, Integer> map = new HashMap<>();

            int len = cs.length, res = 0;
            int start = 0, end = 0, uniq = 0;

            while (end < min - 1) {
                if (cnt[cs[end++]]++ == 0) uniq++;
            }

            while (end < len) {
                if (cnt[cs[end++]]++ == 0) uniq++;
                if (uniq <= letters) {
                    String sub = new String(cs, start, min);
                    int occ = map.getOrDefault(sub, 0) + 1;
                    map.put(sub, occ);
                    res = Math.max(res, occ);
                }
                if (--cnt[cs[start++]] == 0) uniq--;
            }
            return res;
        }
    }


}
