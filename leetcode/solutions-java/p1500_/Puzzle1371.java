package p1500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 *
 * @author half-dead
 */
public class Puzzle1371 {

    class Solution {
        char[] masks = {1, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0};

        public int findTheLongestSubstring(String s) {
            int mask = 0, res = 0;
            int[] map = new int[32];
            Arrays.fill(map, -1);
            for (int i = 0; i < s.length(); ++i) {
                mask ^= masks[s.charAt(i) - 'a'];
                if (mask != 0 && map[mask] == -1)
                    map[mask] = i;
                res = Math.max(res, i - map[mask]);
            }
            return res;
        }
    }

    class MapSolution {
        public int findTheLongestSubstring(String s) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int code = 0, max = 0;
            for (int i = 0; i < s.length(); i++) {
                int shift = idx(s.charAt(i));
                if (shift >= 0) {
                    code ^= (1 << shift);
                }
                Integer prev = map.get(code);
                if (prev == null) {
                    map.put(code, i);
                } else {
                    max = Math.max(max, i - prev);
                }
            }
            return max;
        }

        int idx(char c) {
            if (c == 'a') return 0;
            if (c == 'e') return 1;
            if (c == 'i') return 2;
            if (c == 'o') return 3;
            if (c == 'u') return 4;
            return -1;
        }
    }
}
