package p1000_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/most-common-word/
 *
 * @author half-dead
 */
public class Puzzle819_MostCommonWord {

    public static void main(String[] args) {
        Puzzle819_MostCommonWord p = new Puzzle819_MostCommonWord();
        Solution s = p.new Solution();
        String str = s.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println(str);
    }

    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            paragraph = paragraph.toLowerCase();

            Map<String, Integer> map = new HashMap<>();
            Set<String> banSet = new HashSet<>();
            for (String s : banned) banSet.add(s);

            StringBuilder builder = new StringBuilder();
            int max = 1;
            String result = "";
            for (int i = 0; i < paragraph.length(); i++) {
                char c = paragraph.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    builder.append(c);
                }
                if (c < 'a' || c > 'z' || i == paragraph.length() - 1) {
                    if (builder.length() > 0) {
                        String s = builder.toString();
                        if (!banSet.contains(s)) {
                            if (map.containsKey(s)) {
                                int cnt = map.get(s) + 1;
                                map.put(s, cnt);
                                if (max < cnt) {
                                    max = cnt;
                                    result = s;
                                }
                            } else {
                                map.put(s, 1);
                                if (max == 1) {
                                    result = s;
                                }
                            }
                        }
                        builder = new StringBuilder();
                    }
                }
            }
            return result;
        }
    }
}
