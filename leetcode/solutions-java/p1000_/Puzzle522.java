package p1000_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/
 *
 * @author half-dead
 */
public class Puzzle522 {

    public static void main(String[] args) {
        Solution s = new Puzzle522().new Solution();
//        System.out.println(s.findLUSlength(new String[]{"aaa", "aaa", "aa"}));
        System.out.println(s.findLUSlength(new String[]{"aabbcc", "aabbcc", "bc", "bcc"}));
    }

    class Solution {
        public int findLUSlength(String[] strs) {
            Map<String, Integer>[] a = new HashMap[11];
            for (int i = 1; i <= 10; i++) a[i] = new HashMap<>();
            for (String s : strs) {
                Map<String, Integer> map = a[s.length()];
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            int max = 0;
            for (int i = 10; i >= 1; i--) {
                Map<String, Integer> map = a[i];
                if (map.size() == 0) continue;
                max = Math.max(max, i);

                for (String key : map.keySet()) {
                    boolean candidate = true;
                    for (int j = max; j > i; j--) {
                        Set<String> set = a[j].keySet();
                        if (set.size() == 0) continue;

                        for (String longer : set) {
                            if (subseq(key, longer)) {
                                candidate = false;
                                break;
                            }
                        }
                        if (!candidate) break;
                    }
                    if (candidate && map.get(key) == 1) return i;
                }
            }
            return -1;
        }

        boolean subseq(String a, String b) {
            int i = 0, j = 0;
            while (i < a.length()) {
                if (a.charAt(i) == b.charAt(j)) i++;
                if (++j == b.length()) return i == a.length();
            }
            return true;
        }
    }
}
