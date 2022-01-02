package p0500_;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/concatenated-words/
 *
 * @author half-dead
 */
public class Puzzle472 {

    public static void main(String[] args) {
        Solution s = new Puzzle472().new Solution();
        System.out.println(s.findAllConcatenatedWordsInADict(new String[]{
                "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"
//                "cats", "catsdogcats", "dog"
        }));
    }


    // Trie + DFS, TLE for some edge cases
    class Solution {
        String[] words;
        Set<String> dict, res;

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            this.words = words;
            Trie root = buildTrie();
            dict = Arrays.stream(words).collect(Collectors.toSet());
            dict.remove("");
            res = new HashSet<>();

            dfs(root, "", 0);
            return new ArrayList<>(res);
        }

        void dfs(Trie root, String prefix, int cnt) {
            if (root == null) return;
            if (root.c != ' ') prefix += root.c;

            if (dict.contains(prefix)) {
                if (root.idx > -1 && cnt > 0) {
                    res.add(words[root.idx]);
                }
                for (Trie next : root.next) {
                    dfs(next, "", cnt + 1);
                }
            }
            for (Trie next : root.next) {
                dfs(next, prefix, cnt);
            }
        }

        Trie buildTrie() {
            Trie root = new Trie();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() == 0) continue;

                Trie level = root;
                for (char c : words[i].toCharArray()) {
                    int idx = c - 'a';
                    if (level.next[idx] == null) {
                        level.next[idx] = new Trie();
                        level.next[idx].c = c;
                    }
                    level = level.next[idx];
                }
                level.idx = i;
            }
            return root;
        }

        class Trie {
            int idx = -1;
            char c = ' ';
            Trie[] next;

            Trie() {
                next = new Trie[26];
            }
        }
    }

}
