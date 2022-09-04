package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sender-with-largest-word-count/
 *
 * @author half-dead
 */
public class Puzzle2284 {

    class Solution {
        public String largestWordCount(String[] messages, String[] senders) {
            Map<String, Integer> map = new HashMap<>();

            int n = messages.length;
            for (int i = 0; i < n; i++) {
                int cnt = count(messages[i]);
                map.put(senders[i], map.getOrDefault(senders[i], 0) + cnt);
            }

            int max = 0;
            String res = "";
            for (String key : map.keySet()) {
                int v = map.get(key);
                if (v > max || (v == max && res.compareTo(key) < 0)) {
                    max = v;
                    res = key;
                }
            }
            return res;

        }

        int count(String s) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') cnt++;
            }
            return cnt + 1;
        }
    }
}
