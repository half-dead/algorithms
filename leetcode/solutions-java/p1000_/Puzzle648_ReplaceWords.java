package p1000_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/replace-words/
 *
 * @author half-dead
 */
public class Puzzle648_ReplaceWords {

    public static void main(String[] args) {
        Puzzle648_ReplaceWords p = new Puzzle648_ReplaceWords();
        Solution s = p.new Solution();
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(sentence);
        String r = s.replaceWords(dict, sentence);
        System.out.println(r);
    }

    class Solution {
        Map<Character, Trie> map;

        public String replaceWords(List<String> dict, String sentence) {
            buildTrie(dict);
            StringBuilder builder = new StringBuilder();
            for (String word : sentence.split(" ")) {
                if (builder.length() > 0) {
                    builder.append(' ');
                }

                Map<Character, Trie> level = map;
                Trie t;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    t = level.get(c);
                    builder.append(c);
                    if (t != null && t.b) {
                        break;
                    } else if (t != null) {
                        level = t.next;
                    } else {
                        builder.append(word, i + 1, word.length());
                        break;
                    }
                }
            }
            return builder.toString();
        }

        private void buildTrie(List<String> dict) {
            map = new HashMap<>(26);

            for (String word : dict) {
                Map<Character, Trie> level = map;
                Trie t = null;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    t = level.get(c);
                    if (t == null) {
                        t = new Trie(c);
                        level.put(c, t);
                    }
                    level = t.next;
                }
                t.b = true;
            }
        }
    }

    class Trie {
        char c;
        boolean b;
        Map<Character, Trie> next;

        public Trie(char c) {
            this.c = c;
            next = new HashMap<>(26);
        }
    }
}
