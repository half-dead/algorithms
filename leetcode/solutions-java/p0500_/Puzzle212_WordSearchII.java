package p0500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 *
 * @author half-dead
 */
public class Puzzle212_WordSearchII {
    public static void main(String[] args) {
        Puzzle212_WordSearchII p = new Puzzle212_WordSearchII();
        Solution s = p.new Solution();
        char[][] board = {
                "seenew".toCharArray(),
                "tmriva".toCharArray(),
                "obsibd".toCharArray(),
                "wmysen".toCharArray(),
                "ltsnsa".toCharArray(),
                "iezlgn".toCharArray(),
//                "ihkr".toCharArray(),
//                "iflv".toCharArray(),
        };
        String[] words = {"anda", "anes", "anesis", "avener", "avine", "bena", "bend", "benda", "besa", "besan", "bowl", "daven", "embow", "inerm", "irene", "myst", "nane", "nanes", "neem", "reem", "reest", "renew", "rine", "riva", "rive", "riven", "sand", "sane", "sang", "seen", "seer", "send", "sise", "stob", "stow", "teil", "vine", "viner", "vire", "wadna", "wave", "wene", "wots"};
        System.out.println(s.findWords(board, words).size());
    }

    // Trie + dfs + backtracking 13ms
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            Trie root = buildTrie(words);
            List<String> list = new ArrayList<>();
            int rows = board.length, cols = board[0].length;
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    dfs(root.next, board, rows, cols, i, j, list);
            return list;
        }

        void dfs(Trie[] root, char[][] board, int rows, int cols, int row, int col, List<String> list) {
            char c = board[row][col];
            if (c == ' ') return;

            Trie trie = root[c - 'a'];
            if (trie != null) {
                if (trie.end) {
                    list.add(trie.word);
                    trie.end = false;
                }
                Trie[] level = trie.next;
                board[row][col] = ' ';
                if (row > 0) dfs(level, board, rows, cols, row - 1, col, list);
                if (col > 0) dfs(level, board, rows, cols, row, col - 1, list);
                if (row + 1 < rows) dfs(level, board, rows, cols, row + 1, col, list);
                if (col + 1 < cols) dfs(level, board, rows, cols, row, col + 1, list);
                board[row][col] = c;
            }
        }

        private Trie buildTrie(String[] words) {
            Trie root = new Trie();
            for (String word : words) {
                Trie[] level = root.next;
                for (int i = 0; i < word.length(); i++) {
                    int idx = word.charAt(i) - 'a';
                    Trie t = level[idx];
                    if (t == null) {
                        t = new Trie();
                        level[idx] = t;
                    }
                    if (i == word.length() - 1) {
                        t.end = true;
                        t.word = word;
                    }
                    level = t.next;
                }
            }
            return root;
        }

        class Trie {
            Trie[] next;
            boolean end;
            String word;

            public Trie() {
                next = new Trie[26];
            }
        }
    }

    // DFS + backtracking 436ms
    class Solution2 {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> list = new ArrayList<>();
            int rows = board.length, cols = board[0].length;
            for (String word : new HashSet<>(Arrays.asList(words)))
                for (int i = 0; i < rows; i++)
                    for (int j = 0; j < cols; j++)
                        if (dfs(board, rows, cols, i, j, word, 0)) {
                            list.add(word);
                            i = rows;
                            j = cols;
                        }
            return list;
        }

        boolean dfs(char[][] board, int rows, int cols, int row, int col, String word, int idx) {
            if (idx >= word.length()) return true;

            boolean b = false;
            char c = word.charAt(idx);
            if (board[row][col] == c) {
                board[row][col] = '.';
                b = idx == word.length() - 1;
                b = b || row > 0 && dfs(board, rows, cols, row - 1, col, word, idx + 1);
                b = b || col > 0 && dfs(board, rows, cols, row, col - 1, word, idx + 1);
                b = b || row + 1 < rows && dfs(board, rows, cols, row + 1, col, word, idx + 1);
                b = b || col + 1 < cols && dfs(board, rows, cols, row, col + 1, word, idx + 1);
                board[row][col] = c;
            }
            return b;
        }
    }
}
