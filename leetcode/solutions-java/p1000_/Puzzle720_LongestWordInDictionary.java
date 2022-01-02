package p1000_;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 *
 * @author half-dead
 */
public class Puzzle720_LongestWordInDictionary {

    public static void main(String[] args) {
        Solution s = new Puzzle720_LongestWordInDictionary().new Solution();
        System.out.println(s.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(s.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(s.longestWord(new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"}));
    }

    class Solution {
        public String longestWord(String[] words) {
            Trie root = new Trie();
            for (String word : words) {
                Trie[] level = root.next;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    int pos = c - 'a';
                    Trie t = level[pos];
                    if (t == null) {
                        t = new Trie();
                        level[pos] = t;
                        t.c = c;
                    }
                    if (i == word.length() - 1) {
                        t.end = true;
                    }
                    level = t.next;
                }
            }

            StringBuilder result = new StringBuilder();
            dfs(root, new StringBuilder(), result);
            return result.toString();
        }

        private void dfs(Trie root, StringBuilder curr, StringBuilder result) {
            for (Trie node : root.next) {
                if (node != null) {
                    curr.append(node.c);
                    if (node.end) {
                        dfs(node, curr, result);
                        if (curr.length() > result.length())
                            result.delete(0, result.length()).append(curr);
                    }
                    curr.deleteCharAt(curr.length() - 1);
                }
            }
        }

        class Trie {
            Trie[] next;
            boolean end = false;
            char c;

            Trie() {
                next = new Trie[26];
            }
        }
    }
}
