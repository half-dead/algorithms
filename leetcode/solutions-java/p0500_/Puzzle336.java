package p0500_;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 *
 * @author half-dead
 */
public class Puzzle336 {

    public static void main(String[] args) {
        Solution s = new Puzzle336().new Solution();
        System.out.println(s.palindromePairs(new String[]{"lls", "s", "sssll", "abcd", "dcba"}));
    }

    // prefix-trie + suffix-trie + dfs
    class Solution {
        String[] words;
        int n;

        public List<List<Integer>> palindromePairs(String[] words) {
            n = (this.words = words).length;
            Trie root = buildTrie();

            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                Trie level = root;
                char[] cs = words[i].toCharArray();
                int j = 0, m = cs.length;
                for (; j < m; j++) {
                    if (level.ridx >= 0 && level.ridx != i) {
                        if (isPalin(cs, j, m - 1)) {
                            res.add(Arrays.asList(i, level.ridx));
                        }
                    }
                    if ((level = level.next[cs[j] - 'a']) == null) break;
                }
                if (j == m) dfs(level, i, m, res);
            }
            return res;
        }

        void dfs(Trie root, int i, int j, List<List<Integer>> res) {
            if (root == null) return;
            if (root.ridx >= 0 && root.ridx != i) {
                char[] cs = words[root.ridx].toCharArray();
                if (isPalin(cs, 0, cs.length - j - 1)) {
                    res.add(Arrays.asList(i, root.ridx));
                }
            }
            for (Trie child : root.next) dfs(child, i, j, res);
        }

        private boolean isPalin(char[] cs, int i, int j) {
            while (i < j && cs[i] == cs[j]) {
                i++;
                j--;
            }
            return i >= j;
        }

        Trie buildTrie() {
            Trie root = new Trie();
            for (int i = 0; i < n; i++) {
                String r = new StringBuilder(words[i]).reverse().toString();
                Trie level = root;
                for (char c : r.toCharArray()) {
                    int idx = c - 'a';
                    if (level.next[idx] == null) level.next[idx] = new Trie();
                    level = level.next[idx];
                }
                level.ridx = i;
            }
            return root;
        }
    }

    class Trie {
        int ridx = -1;
        Trie[] next;

        Trie() {
            next = new Trie[26];
        }
    }
}
