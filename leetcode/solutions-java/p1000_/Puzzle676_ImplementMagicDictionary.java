package p1000_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-magic-dictionary/
 *
 * @author half-dead
 */
public class Puzzle676_ImplementMagicDictionary {
    public static void main(String[] args) {
        Puzzle676_ImplementMagicDictionary p = new Puzzle676_ImplementMagicDictionary();
        MagicDictionary md = p.new MagicDictionary();
        md.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(md.search("hello"));
        System.out.println(md.search("hhllo"));
        System.out.println(md.search("hell"));
        System.out.println(md.search("leetcoded"));
    }

    class MagicDictionary {
        Trie[] trie;

        public MagicDictionary() {

        }

        public void buildDict(String[] dict) {
            trie = new Trie[26];

            for (String word : dict) {

                char[] chars = word.toCharArray();
                int len = chars.length, len1 = len - 1;
                for (int j = 0; j < len; j++) {

                    char originalChar = word.charAt(j);
                    for (int k = 0; k < 26; k++) {
                        chars[j] = (char) ('a' + k);
                        if (chars[j] != originalChar) {

                            Trie[] level = this.trie;
                            for (int m = 0; m < len; m++) {
                                int idx = chars[m] - 'a';
                                if (level[idx] == null) {
                                    level[idx] = new Trie(idx);
                                }
                                if (m == len1) {
                                    level[idx].b = true;
                                }
                                level = level[idx].next;
                            }

                        }
                    }
                    chars[j] = originalChar;
                }
            }
        }

        public boolean search(String word) {
            Trie[] level = this.trie;
            Trie t = null;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                t = level[idx];
                if (t != null) {
                    level = t.next;
                } else {
                    break;
                }
            }
            return t == null ? false : t.b;
        }
    }

    class Trie {
        int c;
        boolean b;
        Trie[] next;

        public Trie(int c) {
            this.c = c;
            next = new Trie[26];
        }
    }


    class MagicDictionary2 {
        private Map<Integer, List<String>> table;

        public MagicDictionary2() {
            table = new HashMap<>();
        }

        public void buildDict(String[] dict) {
            for (String word : dict) {
                int length = word.length();
                if (!table.containsKey(length)) {
                    table.put(length, new ArrayList<>());
                }
                table.get(length).add(word);
            }
        }

        public boolean search(String word) {
            int length = word.length();
            if (!table.containsKey(length)) {
                return false;
            }
            List<String> wordList = table.get(length);
            for (String str : wordList) {
                int mismatch = 0;
                for (int i = 0; i < length; i++) {
                    if (word.charAt(i) != str.charAt(i)) {
                        mismatch++;
                        if (mismatch > 1) {
                            break;
                        }
                    }
                }
                if (mismatch == 1) {
                    return true;
                }
            }
            return false;
        }
    }


}
