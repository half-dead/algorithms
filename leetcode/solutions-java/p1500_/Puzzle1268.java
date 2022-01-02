package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 *
 * @author half-dead
 */
public class Puzzle1268 {


    // basic idea is trie, but with some tricks
    class Solution {
        public List<List<String>> suggestedProducts(String[] ps, String q) {
            Trie level = buildTrie(ps);

            List<List<String>> res = new ArrayList<>();
            char[] charArray = q.toCharArray();
            for (int i = 0, len = charArray.length; i < len; i++) {

                char c = charArray[i];
                Trie next;
                List<String> list = new ArrayList<>(3), prev = i > 0 ? res.get(i - 1) : null;
                // if previous result is less than 3
                // we can compute current result completely based on previous result
                if (prev != null) {
                    for (String item : prev) {
                        if (item.length() > i && item.charAt(i) == c) {
                            list.add(item);
                        }
                    }
                }

                if (level != null) {
                    next = level.next[c - 'a'];
                    if (prev == null || prev.size() == 3) {
                        list.clear();
                        fill(next, 3, list);
                    }
                    level = next;
                }
                res.add(list);
            }
            return res;
        }

        Trie buildTrie(String[] ps) {
            Trie root = new Trie();

            for (String p : ps) {
                char[] cs = p.toCharArray();
                Trie level = root;
                for (char c : cs) {
                    int idx = c - 'a';
                    Trie next = level.next[idx];
                    if (next == null) {
                        next = new Trie();
                        next.c = c;
                        level.next[idx] = next;
                    }
                    level = next;
                }
                level.word = p;
            }
            return root;
        }

        private void fill(Trie t, int n, List<String> list) {
            if (list.size() == n) {
                return;
            }

            if (t == null) return;
            if (t.word != null) {
                list.add(t.word);
            }
            for (Trie child : t.next) {
                fill(child, n, list);
            }
        }

        class Trie {
            char c;
            Trie[] next;
            String word;

            Trie() {
                next = new Trie[26];
            }
        }
    }
}
