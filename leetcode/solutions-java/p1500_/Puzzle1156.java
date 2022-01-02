package p1500_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 *
 * @author half-dead
 */
public class Puzzle1156 {

    class Solution {
        public int maxRepOpt1(String text) {
            char[] cs = text.toCharArray();
            int[] fq = new int[128];

            char prev = ' ';
            int cnt = 0;
            Map<Character, List<int[]>> map = new HashMap<>();
            for (int i = 0; i <= cs.length; i++) {
                char c = i == cs.length ? ' ' : cs[i];
                fq[c]++;
                if (c == prev) {
                    cnt++;
                } else {
                    map.computeIfAbsent(prev, (x) -> new ArrayList<>()).add(new int[]{i - 1, cnt});
                    prev = c;
                    cnt = 1;
                }
            }

            int res = 0;
            for (char c : map.keySet()) {
                List<int[]> groups = map.get(c);
                for (int i = 0; i < groups.size(); i++) {
                    int[] group = groups.get(i);
                    res = Math.max(res, group[1] == fq[c] ? group[1] : (group[1] + 1));
                    if (i > 0) {
                        int[] prevgroup = groups.get(i - 1);
                        if (prevgroup[0] + 1 + group[1] == group[0]) {
                            int join = prevgroup[1] + group[1] + 1;
                            res = Math.max(res, join > fq[c] ? join - 1 : join);
                        }
                    }
                }
            }
            return res;
        }
    }
}
