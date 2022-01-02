package p1500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/html-entity-parser/
 *
 * @author half-dead
 */
public class Puzzle1410_HTMLEntityParser {

    class Solution {
        private Map<String, String> map;

        public Solution() {
            map = new HashMap<>();
            map.put("&quot;", "\"");
            map.put("&apos;", "'");
            map.put("&gt;", ">");
            map.put("&lt;", "<");
            map.put("&frasl;", "/");
            map.put("&amp;", "&");
        }

        public String entityParser(String text) {
            StringBuilder result = new StringBuilder(), pattern = new StringBuilder();
            char[] chars = text.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '&') {
                    pattern.setLength(0);
                    pattern.append('&');
                } else if (pattern.length() > 0) {
                    pattern.append(chars[i]);

                    if (pattern.length() >= 4 && pattern.length() <= 7) {
                        String ps = pattern.toString();
                        if (map.containsKey(ps)) {
                            result.append(map.get(ps));
                            pattern.setLength(0);
                            pattern = new StringBuilder();
                        }
                    }
                } else {
                    result.append(chars[i]);
                    if (pattern.length() > 0) {
                        pattern.setLength(0);
                    }
                }
            }
            result.append(pattern);
            return result.toString();
        }
    }

    class ReplaceAllSolution {
        public String entityParser(String text) {
            return text.replaceAll("&quot;", "\"")
                    .replaceAll("&apos;", "'")
                    .replaceAll("&gt;", ">")
                    .replaceAll("&lt;", "<")
                    .replaceAll("&frasl;", "/")
                    .replaceAll("&amp;", "&");

        }
    }
}
