package p0500_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * @author half-dead
 */
public class Puzzle030_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Puzzle030_SubstringWithConcatenationOfAllWords p = new Puzzle030_SubstringWithConcatenationOfAllWords();
        Solution s = p.new Solution();
        System.out.println(s.findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
    }

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> indexes = new ArrayList<>();
            if (words.length == 0) return indexes;

            int wordLen = words[0].length(), totalLen = wordLen * words.length;
            if (totalLen > s.length()) return indexes;

            Map<String, Integer> strings = new HashMap<>();
            for (String word : words) {
                strings.put(word, strings.getOrDefault(word, 0) + 1);
            }

            Map<String, Integer> temp = new HashMap<>();
            for (int k = 0; k < wordLen; k++) {
                for (int i = k; i <= s.length() - totalLen; i += wordLen) {
                    int j = i + totalLen;

                    for (; j > i; j -= wordLen) {
                        String word = s.substring(j - wordLen, j);
                        if (temp.getOrDefault(word, 0) + 1 > strings.getOrDefault(word, 0)) {
                            i = j - wordLen;
                            break;
                        }
                        temp.put(word, temp.getOrDefault(word, 0) + 1);
                    }

                    if (j == i) indexes.add(i);
                    temp.clear();
                }
            }
            return indexes;
        }
    }

    class Solution2 {
        public List<Integer> findSubstring(String s, String[] words) {
            if (words == null || words.length == 0) {
                return new ArrayList<>();
            }
            Map<String, Integer> map = new HashMap<>();
            List<Integer> result = new ArrayList<>();

            for (String w : words) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            int len = words[0].length();

            for (int i = 0; i + len <= s.length(); i++) {
                String word = s.substring(i, i + len);

                if (map.containsKey(word)) {
                    Map<String, Integer> copy = new HashMap<>(map);
                    int j = i;
                    do {
                        int repeat = copy.get(word);
                        if (repeat == 1) {
                            copy.remove(word);
                        } else {
                            copy.put(word, repeat - 1);
                        }
                        j += len;
                        if (j + len > s.length()) {
                            break;
                        }
                        word = s.substring(j, j + len);
                    } while (copy.containsKey(word));
                    if (copy.size() == 0) {
                        result.add(i);
                    }
                }
            }
            return result;
        }
    }
}
