package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/groups-of-strings/
 *
 * @author half-dead
 */
public class Puzzle2157 {

    class Solution {
        int[] digits = new int[26];

        public int[] groupStrings(String[] words) {
            for (int i = 0; i < 26; i++) {
                digits[i] = 1 << i;
            }
            int n = words.length;
            int[] codes = new int[n];
            Map<Integer, Integer> map = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                String w = words[i];
                int code = 0;
                for (char c : w.toCharArray()) {
                    code |= 1 << (c - 'a');
                }
                codes[i] = code;
                map.put(code, map.getOrDefault(code, 0) + 1);
            }

            int[] res = new int[2];
            for (int i = 0; i < n; i++) {
                int temp = dfs(codes[i], map);
                if (temp > 0) {
                    res[0]++;
                    res[1] = Math.max(res[1], temp);
                }
            }
            return res;
        }

        int dfs(int code, Map<Integer, Integer> map) {
            if (code == 0 || !map.containsKey(code)) return 0;

            int ans = map.get(code), anti = ~code;
            map.remove(code);

            for (int j = 0; j < 26; j++) {
                int dj = digits[j];
                if ((code & dj) != 0) {
                    ans += dfs(code - dj, map);
                } else {
                    ans += dfs(code + dj, map);
                }

                if ((anti & dj) != 0) {
                    for (int k = 0; k < 26; k++) {
                        int dk = digits[k];
                        if ((code & dk) != 0) {
                            ans += dfs(code - dk + dj, map);
                        }
                    }
                }
            }
            return ans;
        }
    }
}
