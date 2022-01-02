package p0500_;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 *
 * @author half-dead
 */
public class Puzzle211 {
    public static void main(String[] args) {
        WordDictionary wd = new Puzzle211().new WordDictionary();

        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        wd.addWord("m");
        wd.addWord("ma");
        System.out.println(wd.search("."));
        System.out.println(wd.search(".."));
        System.out.println(wd.search("..."));
        System.out.println(wd.search("b.."));

    }

    class WordDictionary {
        TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                node = node.children[idx] != null ? node.children[idx] : (node.children[idx] = new TrieNode());
            }
            node.end = true;
        }

        public boolean search(String word) {
            return search(word.toCharArray(), 0, root);
        }

        private boolean search(char[] c, int k, TrieNode root) {
            if (k == c.length) return root.end;
            if (c[k] != '.')
                return (root = root.children[c[k] - 'a']) != null && search(c, k + 1, root);

            for (TrieNode child : root.children)
                if (child != null && search(c, k + 1, child)) return true;
            return false;
        }

        class TrieNode {
            boolean end;
            TrieNode[] children = new TrieNode[26];
        }
    }
}
